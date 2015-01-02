package org.apidl;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apidl.model.DeclaredInterface;
import org.apidl.model.DeclaredMethod;
import org.apidl.model.DeclaredMethodParameter;
import org.apidl.model.DeclaredNamespace;
import org.apidl.model.DeclaredRequire;
import org.apidl.model.Restriction;
import org.apidl.model.impl.DeclaredInterfaceImpl;
import org.apidl.model.impl.DeclaredInterfaceImpl.AccessType;
import org.apidl.model.impl.DeclaredMethodImpl;
import org.apidl.model.impl.DeclaredNamespaceImpl;
import org.apidl.model.impl.DeclaredRequireImpl;
import org.apidl.model.impl.RestrictionImpl;

public class APIDLTools {
	
	/**
	 * This method returns a list of the individual platform/language interfaces that are
	 * contained (defined) within the given root interface.
	 * 
	 * @param rootInterface
	 * @return
	 */
	public Map<Restriction, DeclaredInterface> extractContainedInterfaces(DeclaredInterface rootInterface) {
		Map<Restriction, DeclaredInterface> containedInterfaces = new HashMap<Restriction,DeclaredInterface>();
		
		DeclaredInterface commonInterface = new DeclaredInterfaceImpl();
		
		
		List<Restriction> restrictionCache = new ArrayList<Restriction>();
		
		// namespaces
		List<DeclaredNamespace> namespaces = rootInterface.getNamespaces();
		for (DeclaredNamespace namespace : namespaces) {
			if (namespace.hasRestrictions()) {
				for (Restriction restriction : namespace.getRestrictions()) {
					Restriction cachedRestriction = findEquivalentRestriction(restriction, restrictionCache);
					
					DeclaredInterface declaredInterface =  findOrCreateDeclaredInterfaceInMap(containedInterfaces, cachedRestriction);
					declaredInterface.addNamespace(createRestrictedNamespace(namespace, cachedRestriction));
				}
			} else {
				commonInterface.addNamespace(namespace);
			}
		}
		
		// requires
		List<DeclaredRequire> requires = rootInterface.getRequires();
		for (DeclaredRequire require : requires) {
			if (require.hasRestrictions()) {
				for (Restriction restriction : require.getRestrictions()) {
					Restriction cachedRestriction = findEquivalentRestriction(restriction, restrictionCache);
					
					DeclaredInterface declaredInterface =  findOrCreateDeclaredInterfaceInMap(containedInterfaces, cachedRestriction);
					declaredInterface.addRequire(createRestrictedRequire(require, cachedRestriction));
				}
			} else {
				commonInterface.addRequire(require);
			}
		}
				
		// Where restriction targets match - use a generic restriction based only on target, but allow
		//  methods to be stored with version and operator information
		
		// methods
		// FIXME: Implement restriction filtering on method parameters.
		List<DeclaredMethod> methods = rootInterface.getMethods();
		for (DeclaredMethod method : methods) {
			if (method.hasRestrictions()) {
				for (Restriction restriction : method.getRestrictions()) {
					Restriction cachedRestriction = findEquivalentRestriction(restriction, restrictionCache);
					
					DeclaredInterface declaredInterface =  findOrCreateDeclaredInterfaceInMap(containedInterfaces, cachedRestriction);
					DeclaredMethodImpl restrictedMethod = createRestrictedMethodForTarget(method, cachedRestriction.getPlatform());
					declaredInterface.addMethod(restrictedMethod);
				}
			} else {
				commonInterface.addMethod(method);
			}
		}
		
		// interface name
		// FIXME: Need to correct/introduce restrictions for name but for now...
		Iterator<Restriction> restrictionIterator = containedInterfaces.keySet().iterator();
		while (restrictionIterator.hasNext()) {
			DeclaredInterface containedInterface = containedInterfaces.get(restrictionIterator.next());
			containedInterface.setName(rootInterface.getName());
			containedInterface.setType(rootInterface.getType());
			
			for (DeclaredNamespace namespace : commonInterface.getNamespaces()) {
				containedInterface.addNamespace(namespace);
			}
			
			for (DeclaredRequire required : commonInterface.getRequires()) {
				containedInterface.addRequire(required);
			}
			
			// loop through all the common methods checking if the declared interface contains any
			// overridden or overloaded copies of common methods... ...if so, don't add the common
			// method in.
			List<DeclaredMethod> commonMethods = new ArrayList<DeclaredMethod>();
			for (DeclaredMethod commonMethod : commonInterface.getMethods()) {
				if (!containsOverriddenMethod(commonMethod, containedInterface.getMethods())) {
					containedInterface.addMethod(commonMethod);
				}
			}
		}
		
		return containedInterfaces;
	}
	
	protected boolean containsOverriddenMethod(DeclaredMethod methodToCheck, List<DeclaredMethod> methodsToCompareWith) {
		boolean containsOverridenMethod = false;
		for (DeclaredMethod methodToCompareWith : methodsToCompareWith) {
			if (isOverridenMethod(methodToCheck,methodToCompareWith)) {
				containsOverridenMethod = true;
				break;
			}
		}
		return containsOverridenMethod;
	}
	
	protected boolean isOverridenMethod(DeclaredMethod methodToCheckAgainst, DeclaredMethod potentiallyOverridenMethod) {
		boolean overriddenMethod = false;
		
		if (methodToCheckAgainst.getName().equals(potentiallyOverridenMethod.getName())) {
			if (methodToCheckAgainst.getReturnType() == null && potentiallyOverridenMethod.getReturnType() == null) {
				overriddenMethod = true;
			} else {
				if (methodToCheckAgainst.getReturnType() != null && potentiallyOverridenMethod.getReturnType() != null) {
					if (methodToCheckAgainst.getReturnType().getName().equals(potentiallyOverridenMethod.getReturnType().getName())) {
						if (methodToCheckAgainst.getReturnType().getGenericType() == null && potentiallyOverridenMethod.getReturnType().getGenericType() == null) {
							overriddenMethod = true;
						} else {
							if (methodToCheckAgainst.getReturnType().getGenericType() != null && potentiallyOverridenMethod.getReturnType().getGenericType() != null) {
								if (methodToCheckAgainst.getReturnType().getGenericType().equals(potentiallyOverridenMethod.getReturnType().getGenericType())) {
									overriddenMethod = true;
								}
							}
						}
					}
				}
			}
		}
		
		
		return overriddenMethod;
	}
	
	
	
	protected DeclaredMethodImpl createRestrictedMethodForTarget(DeclaredMethod method, String target) {
		DeclaredMethodImpl restrictedMethod = new DeclaredMethodImpl(method.getName());
		restrictedMethod.setReturnType(method.getReturnType());
		
		for (DeclaredMethodParameter parameter : method.getParameters()) {
			restrictedMethod.addParameter(parameter);
		}
		
		// FIXME: Sort out parameter filtering here later when restrictions can be added to parameters.
		
		for (Restriction restriction : method.getRestrictions()) {
			if (restriction.getPlatform().equals(target)) {
				restrictedMethod.addRestriction(restriction);
			}
		}
		
		return restrictedMethod;
	}
	
	protected boolean containsMethod(DeclaredMethod method, List<DeclaredMethodImpl> listOfMethods) {
		boolean containsMethod = false;		
		for (DeclaredMethod listMethod : listOfMethods) {
			if (isSameMethod(method,listMethod)) {
				containsMethod = true;
			}
		}
		return containsMethod;
	}
	
	// Currently ignores any restrictions attached to either method
	protected boolean isSameMethod(DeclaredMethod method1, DeclaredMethod method2) {
		boolean sameMethod = false;
		if (method1.getName().equals(method2.getName())) {			
			if (method1.hasParameters() && method1.hasParameters()) {
				if (method1.getParameters().size() == method2.getParameters().size()) {
					boolean allParamsMatch = true;
					for (int parameterIndex=0;parameterIndex < method1.getParameters().size(); parameterIndex++) {
						
						if (!isSameParameter(method1.getParameters().get(parameterIndex),
								method2.getParameters().get(parameterIndex))) {
							allParamsMatch = false;
							break;
						}
					}
					
					if (allParamsMatch) {
						sameMethod = true;
					}
				}
			}
		}		
		return sameMethod;
	}
	
	// Currently ignores any restrictions attached to either parameter
	protected boolean isSameParameter(DeclaredMethodParameter parameter1, DeclaredMethodParameter parameter2) {
		boolean sameParameter = false;
		
		if (parameter1.getParameterType() == parameter2.getParameterType()) {
			if (parameter1.getName().equals(parameter2.getName())) {
				if (parameter1.getType().getName().equals(parameter2.getType().getName())) {
					
					if (parameter1.getType().getGenericType() == null && parameter1.getType().getGenericType() == null) {
						sameParameter = true;
					} else if ((parameter1.getType().getGenericType() != null && parameter2.getType().getGenericType() != null) &&	
							    parameter1.getType().getGenericType().equals(parameter2.getType().getGenericType())) {
						sameParameter = true;
					}
				}
			}
		}
		return sameParameter;
	}
	
	protected DeclaredMethod createRestrictedMethod(DeclaredMethod method, RestrictionImpl restriction) {
		DeclaredMethod restrictedMethod = new DeclaredMethodImpl(method.getName());
		restrictedMethod.addRestriction(restriction);
		restrictedMethod.getParameters().addAll(method.getParameters());
		return restrictedMethod;
	}
	
	private Restriction findEquivalentRestriction(Restriction searchRestriction, List<Restriction> listOfRestrictions) {
		Restriction equivalentRestriction = null;
		
		for (Restriction restriction : listOfRestrictions) {
			if (restriction.getPlatform().equalsIgnoreCase(searchRestriction.getPlatform())) {
				if (searchRestriction.getVersion() != null) {
					if (restriction.getVersion() != null) {
						// compare versions here ....
					} else {
						equivalentRestriction = restriction;
						break;
					}
				} else {
					equivalentRestriction = restriction;
					break;
				}
			}
		}
		
		if (equivalentRestriction == null) {
			listOfRestrictions.add(searchRestriction);
			equivalentRestriction = searchRestriction;
		}
		
		return equivalentRestriction;
	}
	
	// This creates a single restriction limitation which is incorrect...
	// ...need logic to check if the additional restrictions are complimentary?
	protected DeclaredRequire createRestrictedRequire(DeclaredRequire require, Restriction restriction) {
		DeclaredRequire restrictedRequire = new DeclaredRequireImpl(require.getName());
		restrictedRequire.addRestriction(restriction);
		return restrictedRequire;
	}
	
	// This creates a single restriction limitation which is incorrect...
	// ...need logic to check if the additional restrictions are complimentary?
	protected DeclaredNamespace createRestrictedNamespace(DeclaredNamespace namespace, Restriction restriction) {
		DeclaredNamespace restrictedNamespace = new DeclaredNamespaceImpl(namespace.getName());
		restrictedNamespace.addRestriction(restriction);
		return restrictedNamespace;
	}
	
	protected DeclaredInterface findOrCreateDeclaredInterfaceInMap(Map<Restriction,DeclaredInterface> interfaceMap, Restriction restriction) {
		DeclaredInterface declaredInterface = interfaceMap.get(restriction);
		if (declaredInterface == null) {
			declaredInterface = new DeclaredInterfaceImpl();
			interfaceMap.put(restriction, declaredInterface);
		}
		
		return declaredInterface;		
	}
	
	
	public boolean isValidInterface(DeclaredInterface declaredInterface, Restriction restriction) {
		return false;
	}
	
	
	
	
	
	/**
	 * 
	 * @param declaredInterface
	 * @param restrictions
	 * @return
	 */
	public List<DeclaredNamespace> findNamespace(DeclaredInterface declaredInterface, Restriction restriction) {
		List<DeclaredNamespace> namespaces = new ArrayList<DeclaredNamespace>();
		
		List<DeclaredNamespace> namespacesFromInterface = declaredInterface.getNamespaces();
		if (namespacesFromInterface != null && !namespacesFromInterface.isEmpty()) {
			for (DeclaredNamespace namespace : namespacesFromInterface) {
				if (containsMatchingRestriction(namespace.getRestrictions(), restriction)) {
					namespaces.add(namespace);
				}
			}
		}
		return namespaces;
	}
	
	public List<DeclaredRequire> findRequired(DeclaredInterface declaredInterface, Restriction restriction) {
		List<DeclaredRequire> requiredList = new ArrayList<DeclaredRequire>();
		
		List<DeclaredRequire> requiredFromInterface = declaredInterface.getRequires();
		if (requiredFromInterface != null && !requiredFromInterface.isEmpty()) {
			for (DeclaredRequire required : requiredFromInterface) {
				if (containsMatchingRestriction(required.getRestrictions(), restriction)) {
					requiredList.add(required);
				}
			}
		}		
		return requiredList;
	}
	
	public List<DeclaredMethodImpl> findMethods(DeclaredInterface declaredInterface, Restriction ... restrictions) {
		return null;
	}
	
	public boolean containsMatchingRestriction(List<Restriction> restrictions, Restriction restrictionToMatch) {
		boolean matchedRestriction = false;
		for (Restriction restriction : restrictions) {
			if (isMatchingRestriction(restriction, restrictionToMatch)) {
				matchedRestriction = true;
				break;
			}
		}
		return matchedRestriction;
	}
	
	public boolean isMatchingRestriction(Restriction restriction1, Restriction restriction2) {
		// Check for nulls...
		if (restriction1.getPlatform().equals(restriction2.getPlatform())) {
			// Exact match...
			if (((restriction1.getOperator() == null && restriction2.getOperator() == null) ||
			     (restriction1.getOperator().equals(restriction2.getOperator())) &&
			    ((restriction1.getVersion() == null && restriction2.getVersion() == null) ||
		         (restriction1.getVersion().equals(restriction2.getVersion()))))) {
				return true;
			} else { //
			}
		}
		return false;
	}
	
	
	// This could turn into its own writer class...
	public void write(DeclaredInterface declaredInterface, OutputStream outputStream) throws IOException {
		StringBuilder builder = new StringBuilder();
		
		// Namespaces
		for (DeclaredNamespace namespace : declaredInterface.getNamespaces()) {
			builder.append("namespace");
			builder.append(" ");
			builder.append(namespace.getName());
			
			if (namespace.hasRestrictions()) {
				append(namespace.getRestrictions(), builder);
			}
			builder.append(";");
			builder.append("\n");
			builder.append("\n");
		}
		
		// Requires
		for (DeclaredRequire require : declaredInterface.getRequires()) {
			builder.append("requires");
			builder.append(" ");
			builder.append(require.getName());
			
			if (require.hasRestrictions()) {
				append(require.getRestrictions(), builder);
			}
			builder.append("\n");
		}
		builder.append("\n");
		
		// Name and inheritence information
		if (declaredInterface.getType() == AccessType.PRIVATE) {
			builder.append("private"); 
		} else {
			builder.append("public");
		}
		
		builder.append(" ");
		builder.append(declaredInterface.getName());
		builder.append("\n");
		// FIXME: deal with extends/parent names/for restrictions here later..

		// Methods
		builder.append("{");
		builder.append("\n");
		for (DeclaredMethod method : declaredInterface.getMethods()) {
			builder.append("\t");
			builder.append(method);
			builder.append("\n");
		}
		
		// methods here
		
		builder.append("}");
		builder.append("\n");
		
		
		BufferedOutputStream bos = new BufferedOutputStream(outputStream);
		bos.write(builder.toString().getBytes());
		bos.flush();
	}
	
	public void append(List<Restriction>restrictions ,StringBuilder builder) {
		builder.append(" ");
		builder.append("for");
		builder.append(" ");
		Iterator<Restriction> restrictionsIterator = restrictions.iterator();
		
		while (restrictionsIterator.hasNext()) {
			Restriction restriction = restrictionsIterator.next();
			builder.append(restriction.getPlatform());
			
			if (restriction.getOperator() != null && restriction.getVersion() != null) {
				builder.append(" ");
				builder.append(restriction.getOperator());
				builder.append(" ");
				builder.append(restriction.getVersion());
			}
			
			if (restrictionsIterator.hasNext()) {
				builder.append(" or ");
			}
		}
	}
	
}
