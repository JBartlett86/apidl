// $ANTLR 3.4 /Users/johnbartlett/git/apidl/common/APIDLBuilder.g 2013-09-15 19:29:06

  package org.apidl.antlr;
  
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.TreeNodeStream;
import org.antlr.runtime.tree.TreeParser;
import org.apidl.model.DeclaredInterface;
import org.apidl.model.DeclaredMethodParameter.ParameterType;
import org.apidl.model.DeclaredNamespace;
import org.apidl.model.DeclaredRequire;
import org.apidl.model.Restriction;
import org.apidl.model.Type;
import org.apidl.model.impl.DeclaredInterfaceImpl;
import org.apidl.model.impl.DeclaredInterfaceImpl.AccessType;
import org.apidl.model.impl.DeclaredMethodImpl;
import org.apidl.model.impl.DeclaredMethodParameterImpl;
import org.apidl.model.impl.DeclaredNamespaceImpl;
import org.apidl.model.impl.DeclaredRequireImpl;
import org.apidl.model.impl.RestrictionImpl;
import org.apidl.model.impl.TypeImpl;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class APIDLBuilder extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DEC", "FORRES", "GENERIC", "GENERIC_END", "GENERIC_START", "INTERFACE", "PARAM", "RESTRICTION_OPERATORS", "STRING", "TYPE", "WS", "'('", "')'", "','", "';'", "'extends'", "'for'", "'method'", "'namespace'", "'or'", "'output'", "'private'", "'public'", "'readonly'", "'requires'", "'returns'", "'{'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int DEC=4;
    public static final int FORRES=5;
    public static final int GENERIC=6;
    public static final int GENERIC_END=7;
    public static final int GENERIC_START=8;
    public static final int INTERFACE=9;
    public static final int PARAM=10;
    public static final int RESTRICTION_OPERATORS=11;
    public static final int STRING=12;
    public static final int TYPE=13;
    public static final int WS=14;

    // delegates
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators


    public APIDLBuilder(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public APIDLBuilder(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return APIDLBuilder.tokenNames; }
    public String getGrammarFileName() { return "/Users/johnbartlett/git/apidl/common/APIDLBuilder.g"; }


      DeclaredInterface inter = new DeclaredInterfaceImpl();



    // $ANTLR start "declaration"
    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:20:1: declaration returns [DeclaredInterface e] : ^( DEC ( namespace )* ( requires )* interface_definition ) ;
    public final DeclaredInterface declaration() throws RecognitionException {
        DeclaredInterface e = null;


        DeclaredNamespace namespace1 =null;

        DeclaredRequire requires2 =null;


        try {
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:21:9: ( ^( DEC ( namespace )* ( requires )* interface_definition ) )
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:22:9: ^( DEC ( namespace )* ( requires )* interface_definition )
            {
            e = inter;

            match(input,DEC,FOLLOW_DEC_in_declaration88); 

            match(input, Token.DOWN, null); 
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:23:15: ( namespace )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==22) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:23:16: namespace
            	    {
            	    pushFollow(FOLLOW_namespace_in_declaration91);
            	    namespace1=namespace();

            	    state._fsp--;


            	    inter.addNamespace(namespace1);

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:23:64: ( requires )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==28) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:23:65: requires
            	    {
            	    pushFollow(FOLLOW_requires_in_declaration98);
            	    requires2=requires();

            	    state._fsp--;


            	    inter.addRequire(requires2);

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            pushFollow(FOLLOW_interface_definition_in_declaration104);
            interface_definition();

            state._fsp--;


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return e;
    }
    // $ANTLR end "declaration"



    // $ANTLR start "namespace"
    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:26:1: namespace returns [DeclaredNamespace e] : ^( 'namespace' STRING ( for_restriction )? ) ;
    public final DeclaredNamespaceImpl namespace() throws RecognitionException {
        DeclaredNamespaceImpl e = null;


        CommonTree STRING3=null;
        List<Restriction> for_restriction4 =null;


        try {
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:27:9: ( ^( 'namespace' STRING ( for_restriction )? ) )
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:28:9: ^( 'namespace' STRING ( for_restriction )? )
            {
            match(input,22,FOLLOW_22_in_namespace144); 

            match(input, Token.DOWN, null); 
            STRING3=(CommonTree)match(input,STRING,FOLLOW_STRING_in_namespace146); 

            e = new DeclaredNamespaceImpl((STRING3!=null?STRING3.getText():null));

            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:28:73: ( for_restriction )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==20) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:28:74: for_restriction
                    {
                    pushFollow(FOLLOW_for_restriction_in_namespace151);
                    for_restriction4=for_restriction();

                    state._fsp--;


                    e.addRestrictions(for_restriction4);

                    }
                    break;

            }


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return e;
    }
    // $ANTLR end "namespace"



    // $ANTLR start "requires"
    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:31:1: requires returns [DeclaredRequire e] : ^( 'requires' STRING ( for_restriction )? ) ;
    public final DeclaredRequire requires() throws RecognitionException {
        DeclaredRequireImpl e = null;


        CommonTree STRING5=null;
        List<Restriction> for_restriction6 =null;


        try {
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:32:9: ( ^( 'requires' STRING ( for_restriction )? ) )
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:33:9: ^( 'requires' STRING ( for_restriction )? )
            {
            match(input,28,FOLLOW_28_in_requires202); 

            match(input, Token.DOWN, null); 
            STRING5=(CommonTree)match(input,STRING,FOLLOW_STRING_in_requires204); 

            e = new DeclaredRequireImpl((STRING5!=null?STRING5.getText():null));

            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:33:70: ( for_restriction )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==20) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:33:71: for_restriction
                    {
                    pushFollow(FOLLOW_for_restriction_in_requires209);
                    for_restriction6=for_restriction();

                    state._fsp--;


                    e.addRestrictions(for_restriction6);

                    }
                    break;

            }


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return e;
    }
    // $ANTLR end "requires"



    // $ANTLR start "interface_definition"
    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:36:1: interface_definition : ^( INTERFACE access name= STRING (ext= STRING )? ( for_restriction )? ( method_statement )+ ) ;
    public final void interface_definition() throws RecognitionException {
        CommonTree name=null;
        CommonTree ext=null;
        String access7 =null;

        List<Restriction> for_restriction8 =null;

        DeclaredMethodImpl method_statement9 =null;


        try {
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:37:9: ( ^( INTERFACE access name= STRING (ext= STRING )? ( for_restriction )? ( method_statement )+ ) )
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:38:9: ^( INTERFACE access name= STRING (ext= STRING )? ( for_restriction )? ( method_statement )+ )
            {
            match(input,INTERFACE,FOLLOW_INTERFACE_in_interface_definition256); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_access_in_interface_definition258);
            access7=access();

            state._fsp--;


            name=(CommonTree)match(input,STRING,FOLLOW_STRING_in_interface_definition262); 

            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:38:43: (ext= STRING )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==STRING) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:38:43: ext= STRING
                    {
                    ext=(CommonTree)match(input,STRING,FOLLOW_STRING_in_interface_definition266); 

                    }
                    break;

            }



                    if (access7 != null) {
                      inter.setType(AccessType.valueOf(access7.toUpperCase()));
                    }
                    inter.setName((name!=null?name.getText():null));
                    inter.setExtend((ext!=null?ext.getText():null));
                    

            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:46:9: ( for_restriction )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:46:10: for_restriction
                    {
                    pushFollow(FOLLOW_for_restriction_in_interface_definition290);
                    for_restriction8=for_restriction();

                    state._fsp--;


                    inter.addRestrictions(for_restriction8);

                    }
                    break;

            }


            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:47:9: ( method_statement )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==21) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:47:10: method_statement
            	    {
            	    pushFollow(FOLLOW_method_statement_in_interface_definition305);
            	    method_statement9=method_statement();

            	    state._fsp--;


            	    inter.addMethod(method_statement9);

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "interface_definition"



    // $ANTLR start "access"
    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:50:1: access returns [String e] : ( 'public' | 'private' );
    public final String access() throws RecognitionException {
        String e = null;


        try {
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:51:9: ( 'public' | 'private' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==26) ) {
                alt8=1;
            }
            else if ( (LA8_0==25) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:52:9: 'public'
                    {
                    match(input,26,FOLLOW_26_in_access355); 

                    e = "public";

                    }
                    break;
                case 2 :
                    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:52:36: 'private'
                    {
                    match(input,25,FOLLOW_25_in_access361); 

                    e = "private";

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return e;
    }
    // $ANTLR end "access"



    // $ANTLR start "method_statement"
    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:55:1: method_statement returns [DeclaredMethod e] : ^( 'method' STRING ( parameter )* ( type )? ( for_restriction )? ) ;
    public final DeclaredMethodImpl method_statement() throws RecognitionException {
        DeclaredMethodImpl e = null;


        CommonTree STRING10=null;
        DeclaredMethodParameterImpl parameter11 =null;

        Type type12 =null;

        List<Restriction> for_restriction13 =null;


        try {
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:56:9: ( ^( 'method' STRING ( parameter )* ( type )? ( for_restriction )? ) )
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:57:9: ^( 'method' STRING ( parameter )* ( type )? ( for_restriction )? )
            {
            match(input,21,FOLLOW_21_in_method_statement417); 

            match(input, Token.DOWN, null); 
            STRING10=(CommonTree)match(input,STRING,FOLLOW_STRING_in_method_statement419); 

            e = new DeclaredMethodImpl((STRING10!=null?STRING10.getText():null));

            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:58:11: ( parameter )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==PARAM) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:58:12: parameter
            	    {
            	    pushFollow(FOLLOW_parameter_in_method_statement435);
            	    parameter11=parameter();

            	    state._fsp--;


            	    e.addParameter(parameter11);

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:59:11: ( type )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==TYPE) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:59:12: type
                    {
                    pushFollow(FOLLOW_type_in_method_statement453);
                    type12=type();

                    state._fsp--;


                    e.setReturnType(type12);

                    }
                    break;

            }


            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:60:11: ( for_restriction )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:60:12: for_restriction
                    {
                    pushFollow(FOLLOW_for_restriction_in_method_statement471);
                    for_restriction13=for_restriction();

                    state._fsp--;


                    e.addRestrictions(for_restriction13);

                    }
                    break;

            }


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return e;
    }
    // $ANTLR end "method_statement"



    // $ANTLR start "parameter"
    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:63:1: parameter returns [DeclaredMethodParameter e] : ^( PARAM ( param_oper )? type STRING ( for_restriction )? ) ;
    public final DeclaredMethodParameterImpl parameter() throws RecognitionException {
        DeclaredMethodParameterImpl e = null;


        CommonTree STRING16=null;
        String param_oper14 =null;

        Type type15 =null;

        List<Restriction> for_restriction17 =null;


        try {
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:64:9: ( ^( PARAM ( param_oper )? type STRING ( for_restriction )? ) )
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:65:9: ^( PARAM ( param_oper )? type STRING ( for_restriction )? )
            {
            e = new DeclaredMethodParameterImpl();

            match(input,PARAM,FOLLOW_PARAM_in_parameter532); 

            match(input, Token.DOWN, null); 
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:66:17: ( param_oper )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==24||LA12_0==27) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:66:18: param_oper
                    {
                    pushFollow(FOLLOW_param_oper_in_parameter535);
                    param_oper14=param_oper();

                    state._fsp--;


                    e.setParameterType(ParameterType.valueOf(param_oper14.toUpperCase()));

                    }
                    break;

            }


            pushFollow(FOLLOW_type_in_parameter550);
            type15=type();

            state._fsp--;


            e.setType(type15);

            STRING16=(CommonTree)match(input,STRING,FOLLOW_STRING_in_parameter563); 

            e.setName((STRING16!=null?STRING16.getText():null));

            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:69:9: ( for_restriction )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==20) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:69:10: for_restriction
                    {
                    pushFollow(FOLLOW_for_restriction_in_parameter576);
                    for_restriction17=for_restriction();

                    state._fsp--;


                    e.addRestrictions(for_restriction17);

                    }
                    break;

            }


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return e;
    }
    // $ANTLR end "parameter"



    // $ANTLR start "param_oper"
    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:72:1: param_oper returns [String e] : ( 'output' | 'readonly' );
    public final String param_oper() throws RecognitionException {
        String e = null;


        try {
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:73:3: ( 'output' | 'readonly' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==24) ) {
                alt14=1;
            }
            else if ( (LA14_0==27) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }
            switch (alt14) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:74:3: 'output'
                    {
                    match(input,24,FOLLOW_24_in_param_oper614); 

                    e = "output";

                    }
                    break;
                case 2 :
                    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:75:5: 'readonly'
                    {
                    match(input,27,FOLLOW_27_in_param_oper622); 

                    e = "readonly";

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return e;
    }
    // $ANTLR end "param_oper"



    // $ANTLR start "type"
    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:78:1: type returns [Type e] : ^( TYPE STRING ( generic_type )? ) ;
    public final Type type() throws RecognitionException {
        Type e = null;


        CommonTree STRING18=null;
        String generic_type19 =null;


        try {
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:79:9: ( ^( TYPE STRING ( generic_type )? ) )
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:80:9: ^( TYPE STRING ( generic_type )? )
            {
            match(input,TYPE,FOLLOW_TYPE_in_type664); 

            match(input, Token.DOWN, null); 
            STRING18=(CommonTree)match(input,STRING,FOLLOW_STRING_in_type666); 

            e = new TypeImpl((STRING18!=null?STRING18.getText():null));

            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:80:53: ( generic_type )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==GENERIC) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:80:54: generic_type
                    {
                    pushFollow(FOLLOW_generic_type_in_type671);
                    generic_type19=generic_type();

                    state._fsp--;


                    e.setGenericType(generic_type19);

                    }
                    break;

            }


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return e;
    }
    // $ANTLR end "type"



    // $ANTLR start "generic_type"
    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:83:1: generic_type returns [String e] : ^( GENERIC STRING ) ;
    public final String generic_type() throws RecognitionException {
        String e = null;


        CommonTree STRING20=null;

        try {
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:84:9: ( ^( GENERIC STRING ) )
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:85:9: ^( GENERIC STRING )
            {
            match(input,GENERIC,FOLLOW_GENERIC_in_generic_type722); 

            match(input, Token.DOWN, null); 
            STRING20=(CommonTree)match(input,STRING,FOLLOW_STRING_in_generic_type724); 

            match(input, Token.UP, null); 


            e = (STRING20!=null?STRING20.getText():null);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return e;
    }
    // $ANTLR end "generic_type"



    // $ANTLR start "for_restriction"
    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:88:1: for_restriction returns [List<Restriction> e] : ^( 'for' ( for_type_restriction )+ ) ;
    public final List<Restriction> for_restriction() throws RecognitionException {
        List<Restriction> e = null;


        Restriction for_type_restriction21 =null;


        try {
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:89:9: ( ^( 'for' ( for_type_restriction )+ ) )
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:90:9: ^( 'for' ( for_type_restriction )+ )
            {
            e = new ArrayList<Restriction>();

            match(input,20,FOLLOW_20_in_for_restriction783); 

            match(input, Token.DOWN, null); 
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:91:17: ( for_type_restriction )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==FORRES) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:91:18: for_type_restriction
            	    {
            	    pushFollow(FOLLOW_for_type_restriction_in_for_restriction786);
            	    for_type_restriction21=for_type_restriction();

            	    state._fsp--;


            	    e.add(for_type_restriction21);

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return e;
    }
    // $ANTLR end "for_restriction"



    // $ANTLR start "for_type_restriction"
    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:94:1: for_type_restriction returns [Restriction e] : ^( FORRES platform= STRING ( ( restrictions )? version= STRING )? ) ;
    public final RestrictionImpl for_type_restriction() throws RecognitionException {
        RestrictionImpl e = null;


        CommonTree platform=null;
        CommonTree version=null;
        String restrictions22 =null;


        try {
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:95:9: ( ^( FORRES platform= STRING ( ( restrictions )? version= STRING )? ) )
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:96:9: ^( FORRES platform= STRING ( ( restrictions )? version= STRING )? )
            {
            match(input,FORRES,FOLLOW_FORRES_in_for_type_restriction837); 

            match(input, Token.DOWN, null); 
            platform=(CommonTree)match(input,STRING,FOLLOW_STRING_in_for_type_restriction841); 

            e = new RestrictionImpl((platform!=null?platform.getText():null));

            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:96:73: ( ( restrictions )? version= STRING )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0 >= GENERIC_END && LA18_0 <= GENERIC_START)||(LA18_0 >= RESTRICTION_OPERATORS && LA18_0 <= STRING)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:96:74: ( restrictions )? version= STRING
                    {
                    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:96:74: ( restrictions )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( ((LA17_0 >= GENERIC_END && LA17_0 <= GENERIC_START)||LA17_0==RESTRICTION_OPERATORS) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:96:75: restrictions
                            {
                            pushFollow(FOLLOW_restrictions_in_for_type_restriction847);
                            restrictions22=restrictions();

                            state._fsp--;


                            e.setOperator(restrictions22);

                            }
                            break;

                    }


                    version=(CommonTree)match(input,STRING,FOLLOW_STRING_in_for_type_restriction855); 

                    e.setVersion((version!=null?version.getText():null));

                    }
                    break;

            }


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return e;
    }
    // $ANTLR end "for_type_restriction"



    // $ANTLR start "restrictions"
    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:99:1: restrictions returns [String e] : ( RESTRICTION_OPERATORS | GENERIC_START | GENERIC_END );
    public final String restrictions() throws RecognitionException {
        String e = null;


        CommonTree RESTRICTION_OPERATORS23=null;
        CommonTree GENERIC_START24=null;
        CommonTree GENERIC_END25=null;

        try {
            // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:100:9: ( RESTRICTION_OPERATORS | GENERIC_START | GENERIC_END )
            int alt19=3;
            switch ( input.LA(1) ) {
            case RESTRICTION_OPERATORS:
                {
                alt19=1;
                }
                break;
            case GENERIC_START:
                {
                alt19=2;
                }
                break;
            case GENERIC_END:
                {
                alt19=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }

            switch (alt19) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:101:5: RESTRICTION_OPERATORS
                    {
                    RESTRICTION_OPERATORS23=(CommonTree)match(input,RESTRICTION_OPERATORS,FOLLOW_RESTRICTION_OPERATORS_in_restrictions893); 

                    e = (RESTRICTION_OPERATORS23!=null?RESTRICTION_OPERATORS23.getText():null);

                    }
                    break;
                case 2 :
                    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:102:7: GENERIC_START
                    {
                    GENERIC_START24=(CommonTree)match(input,GENERIC_START,FOLLOW_GENERIC_START_in_restrictions904); 

                    e = (GENERIC_START24!=null?GENERIC_START24.getText():null);

                    }
                    break;
                case 3 :
                    // /Users/johnbartlett/git/apidl/common/APIDLBuilder.g:103:7: GENERIC_END
                    {
                    GENERIC_END25=(CommonTree)match(input,GENERIC_END,FOLLOW_GENERIC_END_in_restrictions914); 

                    e = (GENERIC_END25!=null?GENERIC_END25.getText():null);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return e;
    }
    // $ANTLR end "restrictions"

    // Delegated rules


 

    public static final BitSet FOLLOW_DEC_in_declaration88 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_namespace_in_declaration91 = new BitSet(new long[]{0x0000000010400200L});
    public static final BitSet FOLLOW_requires_in_declaration98 = new BitSet(new long[]{0x0000000010000200L});
    public static final BitSet FOLLOW_interface_definition_in_declaration104 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_22_in_namespace144 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_namespace146 = new BitSet(new long[]{0x0000000000100008L});
    public static final BitSet FOLLOW_for_restriction_in_namespace151 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_28_in_requires202 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_requires204 = new BitSet(new long[]{0x0000000000100008L});
    public static final BitSet FOLLOW_for_restriction_in_requires209 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INTERFACE_in_interface_definition256 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_access_in_interface_definition258 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STRING_in_interface_definition262 = new BitSet(new long[]{0x0000000000301000L});
    public static final BitSet FOLLOW_STRING_in_interface_definition266 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_for_restriction_in_interface_definition290 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_method_statement_in_interface_definition305 = new BitSet(new long[]{0x0000000000200008L});
    public static final BitSet FOLLOW_26_in_access355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_access361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_method_statement417 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_method_statement419 = new BitSet(new long[]{0x0000000000102408L});
    public static final BitSet FOLLOW_parameter_in_method_statement435 = new BitSet(new long[]{0x0000000000102408L});
    public static final BitSet FOLLOW_type_in_method_statement453 = new BitSet(new long[]{0x0000000000100008L});
    public static final BitSet FOLLOW_for_restriction_in_method_statement471 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARAM_in_parameter532 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_param_oper_in_parameter535 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_type_in_parameter550 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STRING_in_parameter563 = new BitSet(new long[]{0x0000000000100008L});
    public static final BitSet FOLLOW_for_restriction_in_parameter576 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_24_in_param_oper614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_param_oper622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPE_in_type664 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_type666 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_generic_type_in_type671 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GENERIC_in_generic_type722 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_generic_type724 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_20_in_for_restriction783 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_for_type_restriction_in_for_restriction786 = new BitSet(new long[]{0x0000000000000028L});
    public static final BitSet FOLLOW_FORRES_in_for_type_restriction837 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_for_type_restriction841 = new BitSet(new long[]{0x0000000000001988L});
    public static final BitSet FOLLOW_restrictions_in_for_type_restriction847 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STRING_in_for_type_restriction855 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RESTRICTION_OPERATORS_in_restrictions893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERIC_START_in_restrictions904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERIC_END_in_restrictions914 = new BitSet(new long[]{0x0000000000000002L});

}