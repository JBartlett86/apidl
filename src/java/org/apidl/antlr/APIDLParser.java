// $ANTLR 3.4 /Users/johnbartlett/git/apidl/common/APIDL.g 2013-09-15 19:29:05
 package org.apidl.antlr; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class APIDLParser extends Parser {
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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public APIDLParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public APIDLParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return APIDLParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/johnbartlett/git/apidl/common/APIDL.g"; }


    public static class declaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "declaration"
    // /Users/johnbartlett/git/apidl/common/APIDL.g:20:1: declaration : ( namespace )* ( requires )* interface_definition EOF -> ^( DEC ( namespace )* ( requires )* interface_definition ) ;
    public final APIDLParser.declaration_return declaration() throws RecognitionException {
        APIDLParser.declaration_return retval = new APIDLParser.declaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token EOF4=null;
        APIDLParser.namespace_return namespace1 =null;

        APIDLParser.requires_return requires2 =null;

        APIDLParser.interface_definition_return interface_definition3 =null;


        Object EOF4_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_interface_definition=new RewriteRuleSubtreeStream(adaptor,"rule interface_definition");
        RewriteRuleSubtreeStream stream_requires=new RewriteRuleSubtreeStream(adaptor,"rule requires");
        RewriteRuleSubtreeStream stream_namespace=new RewriteRuleSubtreeStream(adaptor,"rule namespace");
        try {
            // /Users/johnbartlett/git/apidl/common/APIDL.g:20:13: ( ( namespace )* ( requires )* interface_definition EOF -> ^( DEC ( namespace )* ( requires )* interface_definition ) )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:20:15: ( namespace )* ( requires )* interface_definition EOF
            {
            // /Users/johnbartlett/git/apidl/common/APIDL.g:20:15: ( namespace )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==22) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/johnbartlett/git/apidl/common/APIDL.g:20:15: namespace
            	    {
            	    pushFollow(FOLLOW_namespace_in_declaration85);
            	    namespace1=namespace();

            	    state._fsp--;

            	    stream_namespace.add(namespace1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            // /Users/johnbartlett/git/apidl/common/APIDL.g:20:26: ( requires )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==28) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/johnbartlett/git/apidl/common/APIDL.g:20:26: requires
            	    {
            	    pushFollow(FOLLOW_requires_in_declaration88);
            	    requires2=requires();

            	    state._fsp--;

            	    stream_requires.add(requires2.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            pushFollow(FOLLOW_interface_definition_in_declaration91);
            interface_definition3=interface_definition();

            state._fsp--;

            stream_interface_definition.add(interface_definition3.getTree());

            EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_declaration93);  
            stream_EOF.add(EOF4);


            // AST REWRITE
            // elements: namespace, interface_definition, requires
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 20:61: -> ^( DEC ( namespace )* ( requires )* interface_definition )
            {
                // /Users/johnbartlett/git/apidl/common/APIDL.g:20:64: ^( DEC ( namespace )* ( requires )* interface_definition )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(DEC, "DEC")
                , root_1);

                // /Users/johnbartlett/git/apidl/common/APIDL.g:20:70: ( namespace )*
                while ( stream_namespace.hasNext() ) {
                    adaptor.addChild(root_1, stream_namespace.nextTree());

                }
                stream_namespace.reset();

                // /Users/johnbartlett/git/apidl/common/APIDL.g:20:81: ( requires )*
                while ( stream_requires.hasNext() ) {
                    adaptor.addChild(root_1, stream_requires.nextTree());

                }
                stream_requires.reset();

                adaptor.addChild(root_1, stream_interface_definition.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "declaration"


    public static class namespace_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "namespace"
    // /Users/johnbartlett/git/apidl/common/APIDL.g:22:1: namespace : 'namespace' ^ STRING ( for_restriction )? ';' !;
    public final APIDLParser.namespace_return namespace() throws RecognitionException {
        APIDLParser.namespace_return retval = new APIDLParser.namespace_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal5=null;
        Token STRING6=null;
        Token char_literal8=null;
        APIDLParser.for_restriction_return for_restriction7 =null;


        Object string_literal5_tree=null;
        Object STRING6_tree=null;
        Object char_literal8_tree=null;

        try {
            // /Users/johnbartlett/git/apidl/common/APIDL.g:22:11: ( 'namespace' ^ STRING ( for_restriction )? ';' !)
            // /Users/johnbartlett/git/apidl/common/APIDL.g:22:13: 'namespace' ^ STRING ( for_restriction )? ';' !
            {
            root_0 = (Object)adaptor.nil();


            string_literal5=(Token)match(input,22,FOLLOW_22_in_namespace115); 
            string_literal5_tree = 
            (Object)adaptor.create(string_literal5)
            ;
            root_0 = (Object)adaptor.becomeRoot(string_literal5_tree, root_0);


            STRING6=(Token)match(input,STRING,FOLLOW_STRING_in_namespace118); 
            STRING6_tree = 
            (Object)adaptor.create(STRING6)
            ;
            adaptor.addChild(root_0, STRING6_tree);


            // /Users/johnbartlett/git/apidl/common/APIDL.g:22:33: ( for_restriction )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==20) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDL.g:22:33: for_restriction
                    {
                    pushFollow(FOLLOW_for_restriction_in_namespace120);
                    for_restriction7=for_restriction();

                    state._fsp--;

                    adaptor.addChild(root_0, for_restriction7.getTree());

                    }
                    break;

            }


            char_literal8=(Token)match(input,18,FOLLOW_18_in_namespace123); 

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "namespace"


    public static class requires_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "requires"
    // /Users/johnbartlett/git/apidl/common/APIDL.g:24:1: requires : 'requires' ^ STRING ( for_restriction )? ';' !;
    public final APIDLParser.requires_return requires() throws RecognitionException {
        APIDLParser.requires_return retval = new APIDLParser.requires_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal9=null;
        Token STRING10=null;
        Token char_literal12=null;
        APIDLParser.for_restriction_return for_restriction11 =null;


        Object string_literal9_tree=null;
        Object STRING10_tree=null;
        Object char_literal12_tree=null;

        try {
            // /Users/johnbartlett/git/apidl/common/APIDL.g:24:10: ( 'requires' ^ STRING ( for_restriction )? ';' !)
            // /Users/johnbartlett/git/apidl/common/APIDL.g:24:12: 'requires' ^ STRING ( for_restriction )? ';' !
            {
            root_0 = (Object)adaptor.nil();


            string_literal9=(Token)match(input,28,FOLLOW_28_in_requires132); 
            string_literal9_tree = 
            (Object)adaptor.create(string_literal9)
            ;
            root_0 = (Object)adaptor.becomeRoot(string_literal9_tree, root_0);


            STRING10=(Token)match(input,STRING,FOLLOW_STRING_in_requires135); 
            STRING10_tree = 
            (Object)adaptor.create(STRING10)
            ;
            adaptor.addChild(root_0, STRING10_tree);


            // /Users/johnbartlett/git/apidl/common/APIDL.g:24:31: ( for_restriction )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==20) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDL.g:24:31: for_restriction
                    {
                    pushFollow(FOLLOW_for_restriction_in_requires137);
                    for_restriction11=for_restriction();

                    state._fsp--;

                    adaptor.addChild(root_0, for_restriction11.getTree());

                    }
                    break;

            }


            char_literal12=(Token)match(input,18,FOLLOW_18_in_requires140); 

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "requires"


    public static class interface_definition_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "interface_definition"
    // /Users/johnbartlett/git/apidl/common/APIDL.g:26:1: interface_definition : access n= STRING ( 'extends' ex= STRING )? ( for_restriction )? '{' ( method_statement )+ '}' -> ^( INTERFACE access $n ( $ex)? ( for_restriction )? ( method_statement )+ ) ;
    public final APIDLParser.interface_definition_return interface_definition() throws RecognitionException {
        APIDLParser.interface_definition_return retval = new APIDLParser.interface_definition_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token n=null;
        Token ex=null;
        Token string_literal14=null;
        Token char_literal16=null;
        Token char_literal18=null;
        APIDLParser.access_return access13 =null;

        APIDLParser.for_restriction_return for_restriction15 =null;

        APIDLParser.method_statement_return method_statement17 =null;


        Object n_tree=null;
        Object ex_tree=null;
        Object string_literal14_tree=null;
        Object char_literal16_tree=null;
        Object char_literal18_tree=null;
        RewriteRuleTokenStream stream_30=new RewriteRuleTokenStream(adaptor,"token 30");
        RewriteRuleTokenStream stream_19=new RewriteRuleTokenStream(adaptor,"token 19");
        RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_for_restriction=new RewriteRuleSubtreeStream(adaptor,"rule for_restriction");
        RewriteRuleSubtreeStream stream_method_statement=new RewriteRuleSubtreeStream(adaptor,"rule method_statement");
        RewriteRuleSubtreeStream stream_access=new RewriteRuleSubtreeStream(adaptor,"rule access");
        try {
            // /Users/johnbartlett/git/apidl/common/APIDL.g:27:3: ( access n= STRING ( 'extends' ex= STRING )? ( for_restriction )? '{' ( method_statement )+ '}' -> ^( INTERFACE access $n ( $ex)? ( for_restriction )? ( method_statement )+ ) )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:28:3: access n= STRING ( 'extends' ex= STRING )? ( for_restriction )? '{' ( method_statement )+ '}'
            {
            pushFollow(FOLLOW_access_in_interface_definition155);
            access13=access();

            state._fsp--;

            stream_access.add(access13.getTree());

            n=(Token)match(input,STRING,FOLLOW_STRING_in_interface_definition159);  
            stream_STRING.add(n);


            // /Users/johnbartlett/git/apidl/common/APIDL.g:28:19: ( 'extends' ex= STRING )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDL.g:28:20: 'extends' ex= STRING
                    {
                    string_literal14=(Token)match(input,19,FOLLOW_19_in_interface_definition162);  
                    stream_19.add(string_literal14);


                    ex=(Token)match(input,STRING,FOLLOW_STRING_in_interface_definition166);  
                    stream_STRING.add(ex);


                    }
                    break;

            }


            // /Users/johnbartlett/git/apidl/common/APIDL.g:28:42: ( for_restriction )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDL.g:28:42: for_restriction
                    {
                    pushFollow(FOLLOW_for_restriction_in_interface_definition170);
                    for_restriction15=for_restriction();

                    state._fsp--;

                    stream_for_restriction.add(for_restriction15.getTree());

                    }
                    break;

            }


            char_literal16=(Token)match(input,30,FOLLOW_30_in_interface_definition173);  
            stream_30.add(char_literal16);


            // /Users/johnbartlett/git/apidl/common/APIDL.g:28:63: ( method_statement )+
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
            	    // /Users/johnbartlett/git/apidl/common/APIDL.g:28:64: method_statement
            	    {
            	    pushFollow(FOLLOW_method_statement_in_interface_definition176);
            	    method_statement17=method_statement();

            	    state._fsp--;

            	    stream_method_statement.add(method_statement17.getTree());

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


            char_literal18=(Token)match(input,31,FOLLOW_31_in_interface_definition180);  
            stream_31.add(char_literal18);


            // AST REWRITE
            // elements: method_statement, n, for_restriction, ex, access
            // token labels: ex, n
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_ex=new RewriteRuleTokenStream(adaptor,"token ex",ex);
            RewriteRuleTokenStream stream_n=new RewriteRuleTokenStream(adaptor,"token n",n);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 28:87: -> ^( INTERFACE access $n ( $ex)? ( for_restriction )? ( method_statement )+ )
            {
                // /Users/johnbartlett/git/apidl/common/APIDL.g:28:90: ^( INTERFACE access $n ( $ex)? ( for_restriction )? ( method_statement )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(INTERFACE, "INTERFACE")
                , root_1);

                adaptor.addChild(root_1, stream_access.nextTree());

                adaptor.addChild(root_1, stream_n.nextNode());

                // /Users/johnbartlett/git/apidl/common/APIDL.g:28:113: ( $ex)?
                if ( stream_ex.hasNext() ) {
                    adaptor.addChild(root_1, stream_ex.nextNode());

                }
                stream_ex.reset();

                // /Users/johnbartlett/git/apidl/common/APIDL.g:28:117: ( for_restriction )?
                if ( stream_for_restriction.hasNext() ) {
                    adaptor.addChild(root_1, stream_for_restriction.nextTree());

                }
                stream_for_restriction.reset();

                if ( !(stream_method_statement.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_method_statement.hasNext() ) {
                    adaptor.addChild(root_1, stream_method_statement.nextTree());

                }
                stream_method_statement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "interface_definition"


    public static class access_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "access"
    // /Users/johnbartlett/git/apidl/common/APIDL.g:31:1: access : ( 'public' | 'private' );
    public final APIDLParser.access_return access() throws RecognitionException {
        APIDLParser.access_return retval = new APIDLParser.access_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set19=null;

        Object set19_tree=null;

        try {
            // /Users/johnbartlett/git/apidl/common/APIDL.g:32:3: ( 'public' | 'private' )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:
            {
            root_0 = (Object)adaptor.nil();


            set19=(Token)input.LT(1);

            if ( (input.LA(1) >= 25 && input.LA(1) <= 26) ) {
                input.consume();
                adaptor.addChild(root_0, 
                (Object)adaptor.create(set19)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "access"


    public static class method_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "method_statement"
    // /Users/johnbartlett/git/apidl/common/APIDL.g:36:1: method_statement : 'method' STRING ( '(' ( parameter ( ',' parameter )* )? ')' )? ( 'returns' type )? ( for_restriction )? ';' -> ^( 'method' STRING ( type )? ( parameter )* ( for_restriction )? ) ;
    public final APIDLParser.method_statement_return method_statement() throws RecognitionException {
        APIDLParser.method_statement_return retval = new APIDLParser.method_statement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal20=null;
        Token STRING21=null;
        Token char_literal22=null;
        Token char_literal24=null;
        Token char_literal26=null;
        Token string_literal27=null;
        Token char_literal30=null;
        APIDLParser.parameter_return parameter23 =null;

        APIDLParser.parameter_return parameter25 =null;

        APIDLParser.type_return type28 =null;

        APIDLParser.for_restriction_return for_restriction29 =null;


        Object string_literal20_tree=null;
        Object STRING21_tree=null;
        Object char_literal22_tree=null;
        Object char_literal24_tree=null;
        Object char_literal26_tree=null;
        Object string_literal27_tree=null;
        Object char_literal30_tree=null;
        RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
        RewriteRuleTokenStream stream_17=new RewriteRuleTokenStream(adaptor,"token 17");
        RewriteRuleTokenStream stream_18=new RewriteRuleTokenStream(adaptor,"token 18");
        RewriteRuleTokenStream stream_15=new RewriteRuleTokenStream(adaptor,"token 15");
        RewriteRuleTokenStream stream_16=new RewriteRuleTokenStream(adaptor,"token 16");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleTokenStream stream_29=new RewriteRuleTokenStream(adaptor,"token 29");
        RewriteRuleSubtreeStream stream_parameter=new RewriteRuleSubtreeStream(adaptor,"rule parameter");
        RewriteRuleSubtreeStream stream_for_restriction=new RewriteRuleSubtreeStream(adaptor,"rule for_restriction");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // /Users/johnbartlett/git/apidl/common/APIDL.g:37:3: ( 'method' STRING ( '(' ( parameter ( ',' parameter )* )? ')' )? ( 'returns' type )? ( for_restriction )? ';' -> ^( 'method' STRING ( type )? ( parameter )* ( for_restriction )? ) )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:38:3: 'method' STRING ( '(' ( parameter ( ',' parameter )* )? ')' )? ( 'returns' type )? ( for_restriction )? ';'
            {
            string_literal20=(Token)match(input,21,FOLLOW_21_in_method_statement239);  
            stream_21.add(string_literal20);


            STRING21=(Token)match(input,STRING,FOLLOW_STRING_in_method_statement241);  
            stream_STRING.add(STRING21);


            // /Users/johnbartlett/git/apidl/common/APIDL.g:38:19: ( '(' ( parameter ( ',' parameter )* )? ')' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==15) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDL.g:38:20: '(' ( parameter ( ',' parameter )* )? ')'
                    {
                    char_literal22=(Token)match(input,15,FOLLOW_15_in_method_statement244);  
                    stream_15.add(char_literal22);


                    // /Users/johnbartlett/git/apidl/common/APIDL.g:38:24: ( parameter ( ',' parameter )* )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==STRING||LA9_0==24||LA9_0==27) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // /Users/johnbartlett/git/apidl/common/APIDL.g:38:25: parameter ( ',' parameter )*
                            {
                            pushFollow(FOLLOW_parameter_in_method_statement247);
                            parameter23=parameter();

                            state._fsp--;

                            stream_parameter.add(parameter23.getTree());

                            // /Users/johnbartlett/git/apidl/common/APIDL.g:38:35: ( ',' parameter )*
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( (LA8_0==17) ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // /Users/johnbartlett/git/apidl/common/APIDL.g:38:36: ',' parameter
                            	    {
                            	    char_literal24=(Token)match(input,17,FOLLOW_17_in_method_statement250);  
                            	    stream_17.add(char_literal24);


                            	    pushFollow(FOLLOW_parameter_in_method_statement252);
                            	    parameter25=parameter();

                            	    state._fsp--;

                            	    stream_parameter.add(parameter25.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop8;
                                }
                            } while (true);


                            }
                            break;

                    }


                    char_literal26=(Token)match(input,16,FOLLOW_16_in_method_statement258);  
                    stream_16.add(char_literal26);


                    }
                    break;

            }


            // /Users/johnbartlett/git/apidl/common/APIDL.g:38:60: ( 'returns' type )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==29) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDL.g:38:61: 'returns' type
                    {
                    string_literal27=(Token)match(input,29,FOLLOW_29_in_method_statement263);  
                    stream_29.add(string_literal27);


                    pushFollow(FOLLOW_type_in_method_statement265);
                    type28=type();

                    state._fsp--;

                    stream_type.add(type28.getTree());

                    }
                    break;

            }


            // /Users/johnbartlett/git/apidl/common/APIDL.g:38:78: ( for_restriction )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDL.g:38:78: for_restriction
                    {
                    pushFollow(FOLLOW_for_restriction_in_method_statement269);
                    for_restriction29=for_restriction();

                    state._fsp--;

                    stream_for_restriction.add(for_restriction29.getTree());

                    }
                    break;

            }


            char_literal30=(Token)match(input,18,FOLLOW_18_in_method_statement272);  
            stream_18.add(char_literal30);


            // AST REWRITE
            // elements: 21, for_restriction, STRING, parameter, type
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 39:7: -> ^( 'method' STRING ( type )? ( parameter )* ( for_restriction )? )
            {
                // /Users/johnbartlett/git/apidl/common/APIDL.g:39:10: ^( 'method' STRING ( type )? ( parameter )* ( for_restriction )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                stream_21.nextNode()
                , root_1);

                adaptor.addChild(root_1, 
                stream_STRING.nextNode()
                );

                // /Users/johnbartlett/git/apidl/common/APIDL.g:39:28: ( type )?
                if ( stream_type.hasNext() ) {
                    adaptor.addChild(root_1, stream_type.nextTree());

                }
                stream_type.reset();

                // /Users/johnbartlett/git/apidl/common/APIDL.g:39:34: ( parameter )*
                while ( stream_parameter.hasNext() ) {
                    adaptor.addChild(root_1, stream_parameter.nextTree());

                }
                stream_parameter.reset();

                // /Users/johnbartlett/git/apidl/common/APIDL.g:39:45: ( for_restriction )?
                if ( stream_for_restriction.hasNext() ) {
                    adaptor.addChild(root_1, stream_for_restriction.nextTree());

                }
                stream_for_restriction.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "method_statement"


    public static class parameter_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parameter"
    // /Users/johnbartlett/git/apidl/common/APIDL.g:42:1: parameter : ( param_oper )? type STRING ( for_restriction )? -> ^( PARAM ( param_oper )? type STRING ( for_restriction )? ) ;
    public final APIDLParser.parameter_return parameter() throws RecognitionException {
        APIDLParser.parameter_return retval = new APIDLParser.parameter_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token STRING33=null;
        APIDLParser.param_oper_return param_oper31 =null;

        APIDLParser.type_return type32 =null;

        APIDLParser.for_restriction_return for_restriction34 =null;


        Object STRING33_tree=null;
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_param_oper=new RewriteRuleSubtreeStream(adaptor,"rule param_oper");
        RewriteRuleSubtreeStream stream_for_restriction=new RewriteRuleSubtreeStream(adaptor,"rule for_restriction");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // /Users/johnbartlett/git/apidl/common/APIDL.g:43:3: ( ( param_oper )? type STRING ( for_restriction )? -> ^( PARAM ( param_oper )? type STRING ( for_restriction )? ) )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:44:3: ( param_oper )? type STRING ( for_restriction )?
            {
            // /Users/johnbartlett/git/apidl/common/APIDL.g:44:3: ( param_oper )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24||LA13_0==27) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDL.g:44:3: param_oper
                    {
                    pushFollow(FOLLOW_param_oper_in_parameter312);
                    param_oper31=param_oper();

                    state._fsp--;

                    stream_param_oper.add(param_oper31.getTree());

                    }
                    break;

            }


            pushFollow(FOLLOW_type_in_parameter315);
            type32=type();

            state._fsp--;

            stream_type.add(type32.getTree());

            STRING33=(Token)match(input,STRING,FOLLOW_STRING_in_parameter317);  
            stream_STRING.add(STRING33);


            // /Users/johnbartlett/git/apidl/common/APIDL.g:44:27: ( for_restriction )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==20) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDL.g:44:27: for_restriction
                    {
                    pushFollow(FOLLOW_for_restriction_in_parameter319);
                    for_restriction34=for_restriction();

                    state._fsp--;

                    stream_for_restriction.add(for_restriction34.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: STRING, for_restriction, type, param_oper
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 44:44: -> ^( PARAM ( param_oper )? type STRING ( for_restriction )? )
            {
                // /Users/johnbartlett/git/apidl/common/APIDL.g:44:47: ^( PARAM ( param_oper )? type STRING ( for_restriction )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(PARAM, "PARAM")
                , root_1);

                // /Users/johnbartlett/git/apidl/common/APIDL.g:44:55: ( param_oper )?
                if ( stream_param_oper.hasNext() ) {
                    adaptor.addChild(root_1, stream_param_oper.nextTree());

                }
                stream_param_oper.reset();

                adaptor.addChild(root_1, stream_type.nextTree());

                adaptor.addChild(root_1, 
                stream_STRING.nextNode()
                );

                // /Users/johnbartlett/git/apidl/common/APIDL.g:44:79: ( for_restriction )?
                if ( stream_for_restriction.hasNext() ) {
                    adaptor.addChild(root_1, stream_for_restriction.nextTree());

                }
                stream_for_restriction.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parameter"


    public static class param_oper_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "param_oper"
    // /Users/johnbartlett/git/apidl/common/APIDL.g:47:1: param_oper : ( 'output' | 'readonly' );
    public final APIDLParser.param_oper_return param_oper() throws RecognitionException {
        APIDLParser.param_oper_return retval = new APIDLParser.param_oper_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set35=null;

        Object set35_tree=null;

        try {
            // /Users/johnbartlett/git/apidl/common/APIDL.g:48:3: ( 'output' | 'readonly' )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:
            {
            root_0 = (Object)adaptor.nil();


            set35=(Token)input.LT(1);

            if ( input.LA(1)==24||input.LA(1)==27 ) {
                input.consume();
                adaptor.addChild(root_0, 
                (Object)adaptor.create(set35)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "param_oper"


    public static class type_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // /Users/johnbartlett/git/apidl/common/APIDL.g:53:1: type : STRING ( generics )? -> ^( TYPE STRING ( generics )? ) ;
    public final APIDLParser.type_return type() throws RecognitionException {
        APIDLParser.type_return retval = new APIDLParser.type_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token STRING36=null;
        APIDLParser.generics_return generics37 =null;


        Object STRING36_tree=null;
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_generics=new RewriteRuleSubtreeStream(adaptor,"rule generics");
        try {
            // /Users/johnbartlett/git/apidl/common/APIDL.g:53:6: ( STRING ( generics )? -> ^( TYPE STRING ( generics )? ) )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:53:8: STRING ( generics )?
            {
            STRING36=(Token)match(input,STRING,FOLLOW_STRING_in_type370);  
            stream_STRING.add(STRING36);


            // /Users/johnbartlett/git/apidl/common/APIDL.g:53:15: ( generics )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==GENERIC_START) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDL.g:53:15: generics
                    {
                    pushFollow(FOLLOW_generics_in_type372);
                    generics37=generics();

                    state._fsp--;

                    stream_generics.add(generics37.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: STRING, generics
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 53:25: -> ^( TYPE STRING ( generics )? )
            {
                // /Users/johnbartlett/git/apidl/common/APIDL.g:53:28: ^( TYPE STRING ( generics )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(TYPE, "TYPE")
                , root_1);

                adaptor.addChild(root_1, 
                stream_STRING.nextNode()
                );

                // /Users/johnbartlett/git/apidl/common/APIDL.g:53:42: ( generics )?
                if ( stream_generics.hasNext() ) {
                    adaptor.addChild(root_1, stream_generics.nextTree());

                }
                stream_generics.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type"


    public static class generics_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "generics"
    // /Users/johnbartlett/git/apidl/common/APIDL.g:55:1: generics : GENERIC_START STRING GENERIC_END -> ^( GENERIC STRING ) ;
    public final APIDLParser.generics_return generics() throws RecognitionException {
        APIDLParser.generics_return retval = new APIDLParser.generics_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token GENERIC_START38=null;
        Token STRING39=null;
        Token GENERIC_END40=null;

        Object GENERIC_START38_tree=null;
        Object STRING39_tree=null;
        Object GENERIC_END40_tree=null;
        RewriteRuleTokenStream stream_GENERIC_END=new RewriteRuleTokenStream(adaptor,"token GENERIC_END");
        RewriteRuleTokenStream stream_GENERIC_START=new RewriteRuleTokenStream(adaptor,"token GENERIC_START");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // /Users/johnbartlett/git/apidl/common/APIDL.g:56:6: ( GENERIC_START STRING GENERIC_END -> ^( GENERIC STRING ) )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:57:6: GENERIC_START STRING GENERIC_END
            {
            GENERIC_START38=(Token)match(input,GENERIC_START,FOLLOW_GENERIC_START_in_generics403);  
            stream_GENERIC_START.add(GENERIC_START38);


            STRING39=(Token)match(input,STRING,FOLLOW_STRING_in_generics405);  
            stream_STRING.add(STRING39);


            GENERIC_END40=(Token)match(input,GENERIC_END,FOLLOW_GENERIC_END_in_generics407);  
            stream_GENERIC_END.add(GENERIC_END40);


            // AST REWRITE
            // elements: STRING
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 57:39: -> ^( GENERIC STRING )
            {
                // /Users/johnbartlett/git/apidl/common/APIDL.g:57:42: ^( GENERIC STRING )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(GENERIC, "GENERIC")
                , root_1);

                adaptor.addChild(root_1, 
                stream_STRING.nextNode()
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "generics"


    public static class for_type_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "for_type_statement"
    // /Users/johnbartlett/git/apidl/common/APIDL.g:60:1: for_type_statement : STRING ( ( restrictions )? STRING )? -> ^( FORRES STRING ( ( restrictions )? STRING )? ) ;
    public final APIDLParser.for_type_statement_return for_type_statement() throws RecognitionException {
        APIDLParser.for_type_statement_return retval = new APIDLParser.for_type_statement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token STRING41=null;
        Token STRING43=null;
        APIDLParser.restrictions_return restrictions42 =null;


        Object STRING41_tree=null;
        Object STRING43_tree=null;
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_restrictions=new RewriteRuleSubtreeStream(adaptor,"rule restrictions");
        try {
            // /Users/johnbartlett/git/apidl/common/APIDL.g:60:20: ( STRING ( ( restrictions )? STRING )? -> ^( FORRES STRING ( ( restrictions )? STRING )? ) )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:60:22: STRING ( ( restrictions )? STRING )?
            {
            STRING41=(Token)match(input,STRING,FOLLOW_STRING_in_for_type_statement429);  
            stream_STRING.add(STRING41);


            // /Users/johnbartlett/git/apidl/common/APIDL.g:60:29: ( ( restrictions )? STRING )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0 >= GENERIC_END && LA17_0 <= GENERIC_START)||(LA17_0 >= RESTRICTION_OPERATORS && LA17_0 <= STRING)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDL.g:60:30: ( restrictions )? STRING
                    {
                    // /Users/johnbartlett/git/apidl/common/APIDL.g:60:30: ( restrictions )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( ((LA16_0 >= GENERIC_END && LA16_0 <= GENERIC_START)||LA16_0==RESTRICTION_OPERATORS) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /Users/johnbartlett/git/apidl/common/APIDL.g:60:30: restrictions
                            {
                            pushFollow(FOLLOW_restrictions_in_for_type_statement432);
                            restrictions42=restrictions();

                            state._fsp--;

                            stream_restrictions.add(restrictions42.getTree());

                            }
                            break;

                    }


                    STRING43=(Token)match(input,STRING,FOLLOW_STRING_in_for_type_statement435);  
                    stream_STRING.add(STRING43);


                    }
                    break;

            }


            // AST REWRITE
            // elements: STRING, restrictions, STRING
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 60:53: -> ^( FORRES STRING ( ( restrictions )? STRING )? )
            {
                // /Users/johnbartlett/git/apidl/common/APIDL.g:60:56: ^( FORRES STRING ( ( restrictions )? STRING )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(FORRES, "FORRES")
                , root_1);

                adaptor.addChild(root_1, 
                stream_STRING.nextNode()
                );

                // /Users/johnbartlett/git/apidl/common/APIDL.g:60:72: ( ( restrictions )? STRING )?
                if ( stream_STRING.hasNext()||stream_restrictions.hasNext() ) {
                    // /Users/johnbartlett/git/apidl/common/APIDL.g:60:73: ( restrictions )?
                    if ( stream_restrictions.hasNext() ) {
                        adaptor.addChild(root_1, stream_restrictions.nextTree());

                    }
                    stream_restrictions.reset();

                    adaptor.addChild(root_1, 
                    stream_STRING.nextNode()
                    );

                }
                stream_STRING.reset();
                stream_restrictions.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "for_type_statement"


    public static class restrictions_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "restrictions"
    // /Users/johnbartlett/git/apidl/common/APIDL.g:62:1: restrictions : ( RESTRICTION_OPERATORS | GENERIC_START | GENERIC_END );
    public final APIDLParser.restrictions_return restrictions() throws RecognitionException {
        APIDLParser.restrictions_return retval = new APIDLParser.restrictions_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set44=null;

        Object set44_tree=null;

        try {
            // /Users/johnbartlett/git/apidl/common/APIDL.g:63:5: ( RESTRICTION_OPERATORS | GENERIC_START | GENERIC_END )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:
            {
            root_0 = (Object)adaptor.nil();


            set44=(Token)input.LT(1);

            if ( (input.LA(1) >= GENERIC_END && input.LA(1) <= GENERIC_START)||input.LA(1)==RESTRICTION_OPERATORS ) {
                input.consume();
                adaptor.addChild(root_0, 
                (Object)adaptor.create(set44)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "restrictions"


    public static class for_restriction_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "for_restriction"
    // /Users/johnbartlett/git/apidl/common/APIDL.g:69:1: for_restriction : 'for' for_type_statement ( 'or' for_type_statement )* -> ^( 'for' ( for_type_statement )+ ) ;
    public final APIDLParser.for_restriction_return for_restriction() throws RecognitionException {
        APIDLParser.for_restriction_return retval = new APIDLParser.for_restriction_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal45=null;
        Token string_literal47=null;
        APIDLParser.for_type_statement_return for_type_statement46 =null;

        APIDLParser.for_type_statement_return for_type_statement48 =null;


        Object string_literal45_tree=null;
        Object string_literal47_tree=null;
        RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
        RewriteRuleTokenStream stream_23=new RewriteRuleTokenStream(adaptor,"token 23");
        RewriteRuleSubtreeStream stream_for_type_statement=new RewriteRuleSubtreeStream(adaptor,"rule for_type_statement");
        try {
            // /Users/johnbartlett/git/apidl/common/APIDL.g:69:17: ( 'for' for_type_statement ( 'or' for_type_statement )* -> ^( 'for' ( for_type_statement )+ ) )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:69:19: 'for' for_type_statement ( 'or' for_type_statement )*
            {
            string_literal45=(Token)match(input,20,FOLLOW_20_in_for_restriction500);  
            stream_20.add(string_literal45);


            pushFollow(FOLLOW_for_type_statement_in_for_restriction502);
            for_type_statement46=for_type_statement();

            state._fsp--;

            stream_for_type_statement.add(for_type_statement46.getTree());

            // /Users/johnbartlett/git/apidl/common/APIDL.g:69:44: ( 'or' for_type_statement )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==23) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /Users/johnbartlett/git/apidl/common/APIDL.g:69:45: 'or' for_type_statement
            	    {
            	    string_literal47=(Token)match(input,23,FOLLOW_23_in_for_restriction505);  
            	    stream_23.add(string_literal47);


            	    pushFollow(FOLLOW_for_type_statement_in_for_restriction507);
            	    for_type_statement48=for_type_statement();

            	    state._fsp--;

            	    stream_for_type_statement.add(for_type_statement48.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            // AST REWRITE
            // elements: 20, for_type_statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 69:71: -> ^( 'for' ( for_type_statement )+ )
            {
                // /Users/johnbartlett/git/apidl/common/APIDL.g:69:74: ^( 'for' ( for_type_statement )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                stream_20.nextNode()
                , root_1);

                if ( !(stream_for_type_statement.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_for_type_statement.hasNext() ) {
                    adaptor.addChild(root_1, stream_for_type_statement.nextTree());

                }
                stream_for_type_statement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "for_restriction"

    // Delegated rules


 

    public static final BitSet FOLLOW_namespace_in_declaration85 = new BitSet(new long[]{0x0000000016400000L});
    public static final BitSet FOLLOW_requires_in_declaration88 = new BitSet(new long[]{0x0000000016000000L});
    public static final BitSet FOLLOW_interface_definition_in_declaration91 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_declaration93 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_namespace115 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STRING_in_namespace118 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_for_restriction_in_namespace120 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_namespace123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_requires132 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STRING_in_requires135 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_for_restriction_in_requires137 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_requires140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_access_in_interface_definition155 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STRING_in_interface_definition159 = new BitSet(new long[]{0x0000000040180000L});
    public static final BitSet FOLLOW_19_in_interface_definition162 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STRING_in_interface_definition166 = new BitSet(new long[]{0x0000000040100000L});
    public static final BitSet FOLLOW_for_restriction_in_interface_definition170 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_interface_definition173 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_method_statement_in_interface_definition176 = new BitSet(new long[]{0x0000000080200000L});
    public static final BitSet FOLLOW_31_in_interface_definition180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_method_statement239 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STRING_in_method_statement241 = new BitSet(new long[]{0x0000000020148000L});
    public static final BitSet FOLLOW_15_in_method_statement244 = new BitSet(new long[]{0x0000000009011000L});
    public static final BitSet FOLLOW_parameter_in_method_statement247 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_method_statement250 = new BitSet(new long[]{0x0000000009001000L});
    public static final BitSet FOLLOW_parameter_in_method_statement252 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_method_statement258 = new BitSet(new long[]{0x0000000020140000L});
    public static final BitSet FOLLOW_29_in_method_statement263 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_type_in_method_statement265 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_for_restriction_in_method_statement269 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_method_statement272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_param_oper_in_parameter312 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_type_in_parameter315 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STRING_in_parameter317 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_for_restriction_in_parameter319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_type370 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_generics_in_type372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERIC_START_in_generics403 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STRING_in_generics405 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_GENERIC_END_in_generics407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_for_type_statement429 = new BitSet(new long[]{0x0000000000001982L});
    public static final BitSet FOLLOW_restrictions_in_for_type_statement432 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STRING_in_for_type_statement435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_for_restriction500 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_for_type_statement_in_for_restriction502 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_for_restriction505 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_for_type_statement_in_for_restriction507 = new BitSet(new long[]{0x0000000000800002L});

}