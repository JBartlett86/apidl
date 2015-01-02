package org.apidl;

import java.lang.reflect.Method;

import org.apidl.model.DeclaredInterface;
import org.apidl.model.DeclaredMethod;
import org.apidl.model.DeclaredMethodParameter;
import org.apidl.model.Type;
import org.apidl.model.impl.DeclaredMethodImpl;
import org.apidl.model.impl.DeclaredMethodParameterImpl;
import org.apidl.model.impl.TypeImpl;

public class ReflectiveDescriptor {

	
	public DeclaredInterface describeInterface(Class _interface) {
		DeclaredInterface describedInterface = null;
		
		if (_interface.isInterface()) {
			
		}
		
		return describedInterface;
	}
	
	public DeclaredMethod describeMethod(Method method) {
		DeclaredMethod describedMethod = null;
		
		if (method != null) {
			describedMethod = new DeclaredMethodImpl(method.getName());
			
			
			if (method.getGenericReturnType() != null) {
				
				// FIXME: Spit out the generic return type if generics in use.
				
			} else if (method.getReturnType() != null) {
				if (method.getReturnType() != void.class) {
					Type returnType = new TypeImpl(method.getReturnType().getSimpleName());
					describedMethod.setReturnType(returnType);
					
				}
			}
			
			int parameterNumber = 1;
			for (Class<?> parameterTypes : method.getParameterTypes()) {
				Type parameterType = new TypeImpl(parameterTypes.getSimpleName());
				DeclaredMethodParameterImpl parameter = new DeclaredMethodParameterImpl();
				if (parameterNumber == 1) {
					parameter.setName(determineFirstParameterName(method));
				} else {
					parameter.setName("parameter"+parameterNumber);
				}
				parameter.setType(parameterType);
				describedMethod.addParameter(parameter);
				
				parameterNumber += 1;
			}
		}
		return describedMethod;
	}
	
	protected String determineFirstParameterName(Method method) {
		String methodName = method.getName();
		
		int charIndex = 0;
		while (Character.isLowerCase(methodName.charAt(charIndex)) &&  charIndex < methodName.length()) {
			charIndex++;
		}

		if (charIndex < methodName.length()) {
			char firstCharacter = Character.toLowerCase(methodName.charAt(charIndex));
			String firstParameterName = firstCharacter + methodName.substring(1 + charIndex);
			return firstParameterName;
		}
		return "parameter1";
	}
}
