// $ANTLR 3.4 /Users/johnbartlett/git/apidl/common/APIDL.g 2013-09-15 19:29:06
 package org.apidl.antlr; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class APIDLLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public APIDLLexer() {} 
    public APIDLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public APIDLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/Users/johnbartlett/git/apidl/common/APIDL.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/johnbartlett/git/apidl/common/APIDL.g:9:7: ( '(' )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:9:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/johnbartlett/git/apidl/common/APIDL.g:10:7: ( ')' )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:10:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/johnbartlett/git/apidl/common/APIDL.g:11:7: ( ',' )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:11:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/johnbartlett/git/apidl/common/APIDL.g:12:7: ( ';' )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:12:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/johnbartlett/git/apidl/common/APIDL.g:13:7: ( 'extends' )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:13:9: 'extends'
            {
            match("extends"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/johnbartlett/git/apidl/common/APIDL.g:14:7: ( 'for' )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:14:9: 'for'
            {
            match("for"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/johnbartlett/git/apidl/common/APIDL.g:15:7: ( 'method' )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:15:9: 'method'
            {
            match("method"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/johnbartlett/git/apidl/common/APIDL.g:16:7: ( 'namespace' )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:16:9: 'namespace'
            {
            match("namespace"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/johnbartlett/git/apidl/common/APIDL.g:17:7: ( 'or' )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:17:9: 'or'
            {
            match("or"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/johnbartlett/git/apidl/common/APIDL.g:18:7: ( 'output' )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:18:9: 'output'
            {
            match("output"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/johnbartlett/git/apidl/common/APIDL.g:19:7: ( 'private' )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:19:9: 'private'
            {
            match("private"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/johnbartlett/git/apidl/common/APIDL.g:20:7: ( 'public' )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:20:9: 'public'
            {
            match("public"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/johnbartlett/git/apidl/common/APIDL.g:21:7: ( 'readonly' )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:21:9: 'readonly'
            {
            match("readonly"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/johnbartlett/git/apidl/common/APIDL.g:22:7: ( 'requires' )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:22:9: 'requires'
            {
            match("requires"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/johnbartlett/git/apidl/common/APIDL.g:23:7: ( 'returns' )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:23:9: 'returns'
            {
            match("returns"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/johnbartlett/git/apidl/common/APIDL.g:24:7: ( '{' )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:24:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/johnbartlett/git/apidl/common/APIDL.g:25:7: ( '}' )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:25:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/johnbartlett/git/apidl/common/APIDL.g:71:15: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' )+ )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:71:17: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' )+
            {
            // /Users/johnbartlett/git/apidl/common/APIDL.g:71:17: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='.'||(LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/johnbartlett/git/apidl/common/APIDL.g:
            	    {
            	    if ( input.LA(1)=='.'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "RESTRICTION_OPERATORS"
    public final void mRESTRICTION_OPERATORS() throws RecognitionException {
        try {
            int _type = RESTRICTION_OPERATORS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/johnbartlett/git/apidl/common/APIDL.g:72:25: ( ( '=' | '>=' | '<=' | '!=' ) )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:72:27: ( '=' | '>=' | '<=' | '!=' )
            {
            // /Users/johnbartlett/git/apidl/common/APIDL.g:72:27: ( '=' | '>=' | '<=' | '!=' )
            int alt2=4;
            switch ( input.LA(1) ) {
            case '=':
                {
                alt2=1;
                }
                break;
            case '>':
                {
                alt2=2;
                }
                break;
            case '<':
                {
                alt2=3;
                }
                break;
            case '!':
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // /Users/johnbartlett/git/apidl/common/APIDL.g:72:28: '='
                    {
                    match('='); 

                    }
                    break;
                case 2 :
                    // /Users/johnbartlett/git/apidl/common/APIDL.g:72:34: '>='
                    {
                    match(">="); 



                    }
                    break;
                case 3 :
                    // /Users/johnbartlett/git/apidl/common/APIDL.g:72:41: '<='
                    {
                    match("<="); 



                    }
                    break;
                case 4 :
                    // /Users/johnbartlett/git/apidl/common/APIDL.g:72:48: '!='
                    {
                    match("!="); 



                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RESTRICTION_OPERATORS"

    // $ANTLR start "GENERIC_START"
    public final void mGENERIC_START() throws RecognitionException {
        try {
            int _type = GENERIC_START;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/johnbartlett/git/apidl/common/APIDL.g:73:15: ( '<' )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:73:17: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GENERIC_START"

    // $ANTLR start "GENERIC_END"
    public final void mGENERIC_END() throws RecognitionException {
        try {
            int _type = GENERIC_END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/johnbartlett/git/apidl/common/APIDL.g:74:13: ( '>' )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:74:15: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GENERIC_END"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/johnbartlett/git/apidl/common/APIDL.g:76:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // /Users/johnbartlett/git/apidl/common/APIDL.g:76:9: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /Users/johnbartlett/git/apidl/common/APIDL.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | STRING | RESTRICTION_OPERATORS | GENERIC_START | GENERIC_END | WS )
        int alt3=22;
        alt3 = dfa3.predict(input);
        switch (alt3) {
            case 1 :
                // /Users/johnbartlett/git/apidl/common/APIDL.g:1:10: T__15
                {
                mT__15(); 


                }
                break;
            case 2 :
                // /Users/johnbartlett/git/apidl/common/APIDL.g:1:16: T__16
                {
                mT__16(); 


                }
                break;
            case 3 :
                // /Users/johnbartlett/git/apidl/common/APIDL.g:1:22: T__17
                {
                mT__17(); 


                }
                break;
            case 4 :
                // /Users/johnbartlett/git/apidl/common/APIDL.g:1:28: T__18
                {
                mT__18(); 


                }
                break;
            case 5 :
                // /Users/johnbartlett/git/apidl/common/APIDL.g:1:34: T__19
                {
                mT__19(); 


                }
                break;
            case 6 :
                // /Users/johnbartlett/git/apidl/common/APIDL.g:1:40: T__20
                {
                mT__20(); 


                }
                break;
            case 7 :
                // /Users/johnbartlett/git/apidl/common/APIDL.g:1:46: T__21
                {
                mT__21(); 


                }
                break;
            case 8 :
                // /Users/johnbartlett/git/apidl/common/APIDL.g:1:52: T__22
                {
                mT__22(); 


                }
                break;
            case 9 :
                // /Users/johnbartlett/git/apidl/common/APIDL.g:1:58: T__23
                {
                mT__23(); 


                }
                break;
            case 10 :
                // /Users/johnbartlett/git/apidl/common/APIDL.g:1:64: T__24
                {
                mT__24(); 


                }
                break;
            case 11 :
                // /Users/johnbartlett/git/apidl/common/APIDL.g:1:70: T__25
                {
                mT__25(); 


                }
                break;
            case 12 :
                // /Users/johnbartlett/git/apidl/common/APIDL.g:1:76: T__26
                {
                mT__26(); 


                }
                break;
            case 13 :
                // /Users/johnbartlett/git/apidl/common/APIDL.g:1:82: T__27
                {
                mT__27(); 


                }
                break;
            case 14 :
                // /Users/johnbartlett/git/apidl/common/APIDL.g:1:88: T__28
                {
                mT__28(); 


                }
                break;
            case 15 :
                // /Users/johnbartlett/git/apidl/common/APIDL.g:1:94: T__29
                {
                mT__29(); 


                }
                break;
            case 16 :
                // /Users/johnbartlett/git/apidl/common/APIDL.g:1:100: T__30
                {
                mT__30(); 


                }
                break;
            case 17 :
                // /Users/johnbartlett/git/apidl/common/APIDL.g:1:106: T__31
                {
                mT__31(); 


                }
                break;
            case 18 :
                // /Users/johnbartlett/git/apidl/common/APIDL.g:1:112: STRING
                {
                mSTRING(); 


                }
                break;
            case 19 :
                // /Users/johnbartlett/git/apidl/common/APIDL.g:1:119: RESTRICTION_OPERATORS
                {
                mRESTRICTION_OPERATORS(); 


                }
                break;
            case 20 :
                // /Users/johnbartlett/git/apidl/common/APIDL.g:1:141: GENERIC_START
                {
                mGENERIC_START(); 


                }
                break;
            case 21 :
                // /Users/johnbartlett/git/apidl/common/APIDL.g:1:155: GENERIC_END
                {
                mGENERIC_END(); 


                }
                break;
            case 22 :
                // /Users/johnbartlett/git/apidl/common/APIDL.g:1:167: WS
                {
                mWS(); 


                }
                break;

        }

    }


    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS =
        "\5\uffff\7\16\4\uffff\1\34\1\35\1\uffff\4\16\1\42\4\16\2\uffff\1"+
        "\16\1\52\2\16\1\uffff\7\16\1\uffff\22\16\1\106\1\16\1\110\1\16\1"+
        "\112\3\16\1\116\1\uffff\1\16\1\uffff\1\120\1\uffff\2\16\1\123\1"+
        "\uffff\1\16\1\uffff\1\125\1\126\1\uffff\1\127\3\uffff";
    static final String DFA3_eofS =
        "\130\uffff";
    static final String DFA3_minS =
        "\1\11\4\uffff\1\170\1\157\1\145\1\141\2\162\1\145\4\uffff\2\75\1"+
        "\uffff\1\164\1\162\1\164\1\155\1\56\1\164\1\151\1\142\1\141\2\uffff"+
        "\1\145\1\56\1\150\1\145\1\uffff\1\160\1\166\1\154\1\144\2\165\1"+
        "\156\1\uffff\1\157\1\163\1\165\1\141\1\151\1\157\1\151\1\162\2\144"+
        "\1\160\2\164\1\143\1\156\1\162\1\156\1\163\1\56\1\141\1\56\1\145"+
        "\1\56\1\154\1\145\1\163\1\56\1\uffff\1\143\1\uffff\1\56\1\uffff"+
        "\1\171\1\163\1\56\1\uffff\1\145\1\uffff\2\56\1\uffff\1\56\3\uffff";
    static final String DFA3_maxS =
        "\1\175\4\uffff\1\170\1\157\1\145\1\141\2\165\1\145\4\uffff\2\75"+
        "\1\uffff\1\164\1\162\1\164\1\155\1\172\1\164\1\151\1\142\1\164\2"+
        "\uffff\1\145\1\172\1\150\1\145\1\uffff\1\160\1\166\1\154\1\144\2"+
        "\165\1\156\1\uffff\1\157\1\163\1\165\1\141\1\151\1\157\1\151\1\162"+
        "\2\144\1\160\2\164\1\143\1\156\1\162\1\156\1\163\1\172\1\141\1\172"+
        "\1\145\1\172\1\154\1\145\1\163\1\172\1\uffff\1\143\1\uffff\1\172"+
        "\1\uffff\1\171\1\163\1\172\1\uffff\1\145\1\uffff\2\172\1\uffff\1"+
        "\172\3\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\7\uffff\1\20\1\21\1\22\1\23\2\uffff\1\26"+
        "\11\uffff\1\25\1\24\4\uffff\1\11\7\uffff\1\6\33\uffff\1\7\1\uffff"+
        "\1\12\1\uffff\1\14\3\uffff\1\5\1\uffff\1\13\2\uffff\1\17\1\uffff"+
        "\1\15\1\16\1\10";
    static final String DFA3_specialS =
        "\130\uffff}>";
    static final String[] DFA3_transitionS = {
            "\2\22\2\uffff\1\22\22\uffff\1\22\1\17\6\uffff\1\1\1\2\2\uffff"+
            "\1\3\1\uffff\1\16\1\uffff\12\16\1\uffff\1\4\1\21\1\17\1\20\2"+
            "\uffff\32\16\6\uffff\4\16\1\5\1\6\6\16\1\7\1\10\1\11\1\12\1"+
            "\16\1\13\10\16\1\14\1\uffff\1\15",
            "",
            "",
            "",
            "",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\27\2\uffff\1\30",
            "\1\31\2\uffff\1\32",
            "\1\33",
            "",
            "",
            "",
            "",
            "\1\17",
            "\1\17",
            "",
            "\1\36",
            "\1\37",
            "\1\40",
            "\1\41",
            "\1\16\1\uffff\12\16\7\uffff\32\16\6\uffff\32\16",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46\17\uffff\1\47\2\uffff\1\50",
            "",
            "",
            "\1\51",
            "\1\16\1\uffff\12\16\7\uffff\32\16\6\uffff\32\16",
            "\1\53",
            "\1\54",
            "",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\16\1\uffff\12\16\7\uffff\32\16\6\uffff\32\16",
            "\1\107",
            "\1\16\1\uffff\12\16\7\uffff\32\16\6\uffff\32\16",
            "\1\111",
            "\1\16\1\uffff\12\16\7\uffff\32\16\6\uffff\32\16",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\16\1\uffff\12\16\7\uffff\32\16\6\uffff\32\16",
            "",
            "\1\117",
            "",
            "\1\16\1\uffff\12\16\7\uffff\32\16\6\uffff\32\16",
            "",
            "\1\121",
            "\1\122",
            "\1\16\1\uffff\12\16\7\uffff\32\16\6\uffff\32\16",
            "",
            "\1\124",
            "",
            "\1\16\1\uffff\12\16\7\uffff\32\16\6\uffff\32\16",
            "\1\16\1\uffff\12\16\7\uffff\32\16\6\uffff\32\16",
            "",
            "\1\16\1\uffff\12\16\7\uffff\32\16\6\uffff\32\16",
            "",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | STRING | RESTRICTION_OPERATORS | GENERIC_START | GENERIC_END | WS );";
        }
    }
 

}