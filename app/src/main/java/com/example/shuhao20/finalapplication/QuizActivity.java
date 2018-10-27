package com.example.shuhao20.finalapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.shuhao20.finalapplication.DataBaseHelper.DatabaseHelper;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    private DatabaseHelper dbh;
    private List<Quiz> quizzes;
    private RadioGroup mRg;
    private RadioButton mRb_1, mRb_2, mRb_3, mRb_4;
    private Button mBtn;
    private TextView mTv_id;
    private TextView mTv_description;
    private TextView mTv_ex;
    private ImageView mIv;
    private Random random = new Random();
    final int rint = random.nextInt(4);
    final int rint_cha = random.nextInt(1);
    private String[] wrongOptions;
    private int position;
    private int chaNum;
    private int quizNum;
    private int right;
    private boolean right_wrong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        dbh = new DatabaseHelper(QuizActivity.this);
        dbh.cleanDatabase();

        mRg = findViewById(R.id.rg);
        mRb_1 = findViewById(R.id.rb_1);
        mRb_2 = findViewById(R.id.rb_2);
        mRb_3 = findViewById(R.id.rb_3);
        mRb_4 = findViewById(R.id.rb_4);
        mBtn = findViewById(R.id.btn);
        mTv_id = findViewById(R.id.tv_id);
        mTv_description = findViewById(R.id.tv_description);
        mTv_ex = findViewById(R.id.tv_ex);
        mIv = findViewById(R.id.iv);

        Intent intent = getIntent();
        position = intent.getIntExtra("pos", 0);
        quizNum = intent.getIntExtra("quizNum", 0);
        right = intent.getIntExtra("right", 0);


        mBtn.setText("See Result");


        Quiz q1 = new Quiz();
        q1.setQuizId(1);
        q1.setDesc("Which is not a JAVA jargon");
        q1.setRightOption("tall");
        q1.setWrongOptions(new String[]{"long", "short", "method"});
        q1.setExplanation("Long and short is the type of data and method is the function that could be used repeat");
        q1.setChapter(1);
        dbh.createQuiz(q1);

        Quiz q2 = new Quiz();
        q2.setQuizId(2);
        q2.setDesc("What is default access specifier for data members or member functions declared within a class without any specifier?");
        q2.setRightOption("Private");
        q2.setWrongOptions(new String[]{"Protected", "Public", "Depends on compiler"});
        q2.setExplanation("The data members and member functions are Private by default in JAVA classes, if none of the access specifier is used. It is actually made to increase the privacy of data.");
        q2.setChapter(1);
        dbh.createQuiz(q2);

        Quiz q3 = new Quiz();
        q3.setQuizId(3);
        q3.setDesc("Which is known as generic class?");
        q3.setRightOption("Template class");
        q3.setWrongOptions(new String[]{"Abstract class", "Final class", "Efficient Code"});
        q3.setExplanation("Template classes are known to be generic classes because those can be used for any data type value and the same class can be used for all the variables of different data types");
        q3.setChapter(1);
        dbh.createQuiz(q3);

        Quiz q4 = new Quiz();
        q4.setQuizId(4);
        q4.setDesc("Size of a class is :____________ ");
        q4.setRightOption("Classes doesn’t have any size");
        q4.setWrongOptions(new String[]{"Sum of size of all the variables declared inside the class", "Sum of size of all the variables along with inherited variables in the class", "Size of largest size of variable"});
        q4.setExplanation("Classes doesn’t have any size, actually the size of object of the class can be defined. That is done only when an object is created and its constructor is called.");
        q4.setChapter(1);
        dbh.createQuiz(q4);

        Quiz q5 = new Quiz();
        q5.setQuizId(5);
        q5.setDesc("Which class can have member functions without their implementation?");
        q5.setRightOption("Abstract class");
        q5.setWrongOptions(new String[]{"Default class", "String class", "Template class"});
        q5.setExplanation("Abstract classes can have member functions with no implementation, where the inheriting subclasses must implement those functions.");
        q5.setChapter(1);
        dbh.createQuiz(q5);

        Quiz q6 = new Quiz();
        q6.setQuizId(6);
        q6.setDesc("Which definition best describes an object?");
        q6.setRightOption("Instance of a class");
        q6.setWrongOptions(new String[]{"Instance of itself", "Child of a class", "Overview of a class"});
        q6.setExplanation("An object is instance of its class. It can be declared in the same way that a variable is declared, only thing is you have to use class name as the data type.");
        q6.setChapter(2);
        dbh.createQuiz(q6);

        Quiz q7 = new Quiz();
        q7.setQuizId(7);
        q7.setDesc("How many objects can be declared of a specific class in a single program?");
        q7.setRightOption("As many as you want");
        q7.setWrongOptions(new String[]{"500", "1024", "1"});
        q7.setExplanation("You can create as many objects of a specific class as you want, provided enough memory is available");
        q7.setChapter(2);
        dbh.createQuiz(q7);

        Quiz q8 = new Quiz();
        q8.setQuizId(8);
        q8.setDesc("Which among the following is false?");
        q8.setRightOption("Objects can’t be passed by reference");
        q8.setWrongOptions(new String[]{"Object must be created before using members of a class", "Memory for an object is allocated only after its constructor is called", "Objects size depends on its class data members"});
        q8.setExplanation("A program is expected to recover if an exception occurs.");
        q8.setChapter(2);
        dbh.createQuiz(q8);


        Quiz q9 = new Quiz();
        q9.setQuizId(9);
        q9.setDesc("How members of an object are accessed?");
        q9.setRightOption("Using dot operator/period symbol");
        q9.setWrongOptions(new String[]{"Using scope resolution operator", "Using member names directly", "Using pointer only"});
        q9.setExplanation("Using dot operator after the name of object we can access its members. It is not necessary to use the pointers. We can’t use the names directly because it may be used outside the class.");
        q9.setChapter(2);
        dbh.createQuiz(q9);

        Quiz q10 = new Quiz();
        q10.setQuizId(10);
        q10.setDesc("The object can’t be:________");
        q10.setRightOption("Passed as function");
        q10.setWrongOptions(new String[]{"Passed by reference", "Passed by value", "Passed by copy"});
        q10.setExplanation("Object can’t be passed as function as it is an instance of some class, it’s not a function. Object can be passed by reference, value or copy. There is no term defined as pass as function for objects.");
        q10.setChapter(2);
        dbh.createQuiz(q10);

        Quiz q11 = new Quiz();
        q11.setQuizId(11);
        q11.setDesc("What is size of the object of following class (64 bit system)??");
        q11.setRightOption("24");
        q11.setWrongOptions(new String[]{"20", "22", "28"});
        q11.setExplanation("The size of any object of student class will be of size 4+20=24, because static members are not really considered as property of a single object. So static variables size will not be added.");
        q11.setChapter(3);
        dbh.createQuiz(q11);

        Quiz q12 = new Quiz();
        q12.setQuizId(12);
        q12.setDesc("Which of the following is incorrect?");
        q12.setRightOption("class student{ }s[];");
        q12.setWrongOptions(new String[]{"class student{ }s;", "class student{ }; student s;", "class student{ }; student s[5];"});
        q12.setExplanation("The array must be specified with a size. You can’t declare object array, or any other linear array without specifying its size. It’s a mandatory field.");
        q12.setChapter(3);
        dbh.createQuiz(q12);

        Quiz q13 = new Quiz();
        q13.setQuizId(13);
        q13.setDesc("Which among the following is wrong?");
        q13.setRightOption("abstract class student{ }; student s;");
        q13.setWrongOptions(new String[]{"class student{ }; student s;", "abstract class student{ }s[50000000];", "abstract class student{ }; class toppers: public student{ }; topper t;"});
        q13.setExplanation("We can never create instance of an abstract class. Abstract classes doesn’t have constructors and hence when an instance is created there is no facility to initialize its members. Option d is correct because topper class is inheriting the base abstract class student, and hence topper class object can be created easily.");
        q13.setChapter(3);
        dbh.createQuiz(q13);

        Quiz q14 = new Quiz();
        q14.setQuizId(14);
        q14.setDesc("Object declared in main() function:__________");
        q14.setRightOption("Can’t be used by any other function");
        q14.setWrongOptions(new String[]{"Can be used by any other function", "Can be used by main() function of any other program", "Can be accessed using scope resolution operator"});
        q14.setExplanation("The object declared in main() have local scope inside main() function only. It can’t be used outside main() function. Scope resolution operator is used to access globally declared variables/objects");
        q14.setChapter(3);
        dbh.createQuiz(q14);

        Quiz q15 = new Quiz();
        q15.setQuizId(15);
        q15.setDesc("When an object is returned___________?");
        q15.setRightOption("A temporary object is created to return the value");
        q15.setWrongOptions(new String[]{"The same object used in function is used to return the value", "The Object can be returned without creation of temporary object", "Object are returned implicitly, we can’t say how it happens inside program"});
        q15.setExplanation("A temporary object is created to return the value. It is created because object used in function is destroyed as soon as the function is returned. The temporary variable returns the value and then gets destroyed.");
        q15.setChapter(3);
        dbh.createQuiz(q15);

        Quiz q16 = new Quiz();
        q16.setQuizId(16);
        q16.setDesc("Which of the following is not a keyword in java?");
        q16.setRightOption("Boolean");
        q16.setWrongOptions(new String[]{"static", "void", "private"});
        q16.setExplanation("Boolean is a class and is not a keyword.");
        q16.setChapter(4);
        dbh.createQuiz(q16);

        Quiz q17 = new Quiz();
        q17.setQuizId(17);
        q17.setDesc("What is the size of char variable?");
        q17.setRightOption("16 bit");
        q17.setWrongOptions(new String[]{"8 bit", "32 bit", "64 bit"});
        q17.setExplanation("The char data type is represented by single 16-bit Unicode character. Minimum value: '\u0000' (or 0) Maximum value: '\uffff' (or 65,535).");
        q17.setChapter(4);
        dbh.createQuiz(q17);

        Quiz q18 = new Quiz();
        q18.setQuizId(18);
        q18.setDesc("What is the default value of byte variable?");
        q18.setRightOption("0");
        q18.setWrongOptions(new String[]{"0.0", "null", "undefined"});
        q18.setExplanation("Byte variable has default value of 0 if defined as an instance/static variable.");
        q18.setChapter(4);
        dbh.createQuiz(q18);

        Quiz q19 = new Quiz();
        q19.setQuizId(19);
        q19.setDesc("Which of the following stands true about default modifier of class members?");
        q19.setRightOption("By default, variables, methods and constructors can be accessed by any class lying in the same package.");
        q19.setWrongOptions(new String[]{"By default, variables, methods and constructors can be accessed by subclass only.", "By default, variables, methods and constructors can be accessed by any class lying in any package.", "None of the above"});
        q19.setExplanation("By default, variables, methods and constructors can be accessed by any class lying in the same package.");
        q19.setChapter(4);
        dbh.createQuiz(q19);

        Quiz q20 = new Quiz();
        q20.setQuizId(20);
        q20.setDesc("Which among the following is true for data members?");
        q20.setRightOption("Static data members are defined outside class, not in constructor");
        q20.setWrongOptions(new String[]{"Private data members can be initialized with declaration in class", "Static members are initialized in constructors", "Protected data members can be initialized in class directly"});
        q20.setExplanation("Static members are not property of instances of classes. Those are shared by all the object of classes. Hence those are defined outside the constructor, so as to make them common for all the objects.");
        q20.setChapter(4);
        dbh.createQuiz(q20);

        Quiz q21 = new Quiz();
        q21.setQuizId(21);
        q21.setDesc("Which of these best describes an array?");
        q21.setRightOption("Container of objects of similar types");
        q21.setWrongOptions(new String[]{"A data structure that shows a hierarchical behavior", "Container of objects of mixed types", "All of the mentioned"});
        q21.setExplanation("Array contains elements only of the same type.");
        q21.setChapter(5);
        dbh.createQuiz(q21);

        Quiz q22 = new Quiz();
        q22.setQuizId(22);
        q22.setDesc("How do you initialize an array in java?");
        q22.setRightOption("int arr[3] = {1,2,3};");
        q22.setWrongOptions(new String[]{"int arr[3] = (1,2,3);", "int arr(3) = {1,2,3};", "int arr(3) = (1,2,3);"});
        q22.setExplanation("This is the syntax to initialize an array in java");
        q22.setChapter(5);
        dbh.createQuiz(q22);

        Quiz q23 = new Quiz();
        q23.setQuizId(23);
        q23.setDesc("How do you instantiate an array in Java?");
        q23.setRightOption("int arr[] = new int[3];");
        q23.setWrongOptions(new String[]{"int arr[] = new int(3);", "int arr[];", "int arr() = new int(3"});
        q23.setExplanation("Note that option b is declaration whereas option c is to instantiate an array.");
        q23.setChapter(5);
        dbh.createQuiz(q23);

        Quiz q24 = new Quiz();
        q24.setQuizId(24);
        q24.setDesc("Which of the following is a correct way to declare a multidimensional array in Java?");
        q24.setRightOption("All of the mentioned");
        q24.setWrongOptions(new String[]{"int[][] arr;", "int arr[][];", "int []arr[];"});
        q24.setExplanation("All the options are syntactically correct");
        q24.setChapter(5);
        dbh.createQuiz(q24);

        Quiz q25 = new Quiz();
        q25.setQuizId(25);
        q25.setDesc("When does the ArrayIndexOutOfBoundsException occur?");
        q25.setRightOption("Run-time");
        q25.setWrongOptions(new String[]{"Compile-time", "Not an error", "None of the mentioned"});
        q25.setExplanation("arrayIndexOutOfBoundsException is a runtime exception and the compilation is errorfree");
        q25.setChapter(5);
        dbh.createQuiz(q25);

        Quiz q26 = new Quiz();
        q26.setQuizId(26);
        q26.setDesc("Which of these selection statements test only for equality?");
        q26.setRightOption("Switch");
        q26.setWrongOptions(new String[]{"If", "If & switch", "None of the above"});
        q26.setExplanation("Switch statements checks for equality between the controlling variable and its constant cases.");
        q26.setChapter(6);
        dbh.createQuiz(q26);

        Quiz q27 = new Quiz();
        q27.setQuizId(27);
        q27.setDesc("Which of these are selection statements in Java?");
        q27.setRightOption("If");
        q27.setWrongOptions(new String[]{"For", "Continue", "Break"});
        q27.setExplanation("Continue and break are jump statements, and for is a looping statement.");
        q27.setChapter(6);
        dbh.createQuiz(q27);

        Quiz q28 = new Quiz();
        q28.setQuizId(28);
        q28.setDesc("Which of the following loops will execute the body of loop even when condition controlling the loop is initially false?");
        q28.setRightOption("Do-while");
        q28.setWrongOptions(new String[]{"While", "For", "None of the above"});
        q28.setExplanation("None.");
        q28.setChapter(6);
        dbh.createQuiz(q28);

        Quiz q29 = new Quiz();
        q29.setQuizId(29);
        q29.setDesc("Which of these jump statements can skip processing remainder of code in its body for a particular iteration?");
        q29.setRightOption("Continue");
        q29.setWrongOptions(new String[]{"Break", "Return", "Exit"});
        q29.setExplanation("You should know this!!!! Read your textbook.");
        q29.setChapter(6);
        dbh.createQuiz(q29);

        Quiz q30 = new Quiz();
        q30.setQuizId(30);
        q30.setDesc("Which of these statement is incorrect?");
        q30.setRightOption("two case constants in the same switch can have identical values");
        q30.setWrongOptions(new String[]{"switch statement is more efficient than a set of nested ifs", "switch statement can only test for equality, whereas if statement can evaluate any type of Boolean expression", "it is possible to create a nested switch statements"});
        q30.setExplanation("No two case constants in the same switch can have identical values.");
        q30.setChapter(6);
        dbh.createQuiz(q30);

        Quiz q31 = new Quiz();
        q1.setQuizId(31);
        q31.setDesc("Which among the following best describes member functions?");
        q31.setRightOption("Functions belonging a class");
        q31.setWrongOptions(new String[]{"Functions which are defined within the class", "Functions in public access of a class", "Functions which are private to class"});
        q31.setExplanation("We can’t say that only functions which are defined inside class are member functions. There can be some inherited functions. Though they doesn’t belong to the class but are property of the objects once inheritance is used. So the nearest definition is functions belonging a class.");
        q31.setChapter(7);
        dbh.createQuiz(q31);

        Quiz q32 = new Quiz();
        q32.setQuizId(32);
        q32.setDesc("What happens if non static variables are used in static variables method?");
        q32.setRightOption("Compile time error");
        q32.setWrongOptions(new String[]{"Runtime error", "Executes fine", "Executes if that member function is not used"});
        q32.setExplanation("here must be specific memory space allocated for the data members before the static member functions uses them. But the space is not reserved if object is not declared. Hence only if static members are not used, it leads to compile time error.");
        q32.setChapter(7);
        dbh.createQuiz(q32);

        Quiz q33 = new Quiz();
        q33.setQuizId(33);
        q33.setDesc("Member function of a class can ____________");
        q33.setRightOption("Access all the members of the class");
        q33.setWrongOptions(new String[]{"Access only Public members of the class", "Access only the private members of the class", "Access subclass members"});
        q33.setExplanation("The member functions has access to all the members of the class. Whenever data members of a class, which might be private, have to be modified, we make use of these member functions. This is more secure way to manipulate data.");
        q33.setChapter(7);
        dbh.createQuiz(q33);

        Quiz q34 = new Quiz();
        q34.setQuizId(34);
        q34.setDesc("Which among the following is not possible for member function?");
        q34.setRightOption("Access public members of subclass");
        q34.setWrongOptions(new String[]{"Access protected members of parent class", "Definition without return type", "Access static members of class"});
        q34.setExplanation("A member function of a class can only have the access to the members of its own class and parent classes if inheritance used. Otherwise a member function can never access the members of a subclass. ");
        q34.setChapter(7);
        dbh.createQuiz(q34);

        Quiz q35 = new Quiz();
        q35.setQuizId(35);
        q35.setDesc("For overloading “( )”, “[ ]” or “->” operators, a class __________");
        q35.setRightOption("Must be non-static member and should not be friend of class");
        q35.setWrongOptions(new String[]{"Must use static member functions", "Must use non-static member functions", "Must use static member function or a friend member function"});
        q35.setExplanation("For overloading those operators for a class, the class must use non-static member function so that doesn’t remain common to all the objects, and each object can use it independently. The friend functions is also restricted so as to keep the security of data.");
        q35.setChapter(7);
        dbh.createQuiz(q35);


        Quiz q36 = new Quiz();
        q36.setQuizId(36);
        q36.setDesc("Which of these class is superclass of String and StringBuffer class?");
        q36.setRightOption("java.lang");
        q36.setWrongOptions(new String[]{"java.util", "ArrayList", "None of the mentioned"});
        q36.setExplanation("None.");
        q36.setChapter(8);
        dbh.createQuiz(q36);

        Quiz q37 = new Quiz();
        q37.setQuizId(37);
        q37.setDesc("Which of these operators can be used to concatenate two or more String objects?");
        q37.setRightOption("+");
        q37.setWrongOptions(new String[]{"+=", "&", "||"});
        q37.setExplanation("Operator + is used to concatenate strings, Example String s = “i ” + “like ” + “java”; String s contains “I like java”.");
        q37.setChapter(8);
        dbh.createQuiz(q37);

        Quiz q38 = new Quiz();
        q38.setQuizId(38);
        q38.setDesc("Which of these method of class String is used to obtain length of String object?");
        q38.setRightOption("length()");
        q38.setWrongOptions(new String[]{"get()", "Sizeof()", "lengthof()"});
        q38.setExplanation(": Method length() of string class is used to get the length of the object which invoked method length().");
        q38.setChapter(8);
        dbh.createQuiz(q38);

        Quiz q39 = new Quiz();
        q39.setQuizId(39);
        q39.setDesc("Which of these is an incorrect statement?");
        q39.setRightOption("StringBuffer class is used to store string in a buffer for later use");
        q39.setWrongOptions(new String[]{"String objects are immutable, they cannot be changed", "String object can point to some other reference of String variable", "None of the mentionedExplanation: StringBuffer class is used to create strings that can be modified after they are created."});
        q39.setExplanation("StringBuffer class is used to create strings that can be modified after they are created.");
        q39.setChapter(8);
        dbh.createQuiz(q39);

        Quiz q40 = new Quiz();
        q40.setQuizId(40);
        q40.setDesc("Which of these constructors is used to create an empty String object?");
        q40.setRightOption("String()");
        q40.setWrongOptions(new String[]{"String(void)", "String(0)", "None of the mentioned"});
        q40.setExplanation("None.");
        q40.setChapter(8);
        dbh.createQuiz(q40);

        Quiz q41 = new Quiz();
        q41.setQuizId(41);
        q41.setDesc("If a function can perform more than 1 type of tasks, where the function name remains same, which feature of OOP is used here?");
        q41.setRightOption("Polymorphism");
        q41.setWrongOptions(new String[]{"Encapsulation", "Inheritance", "Abstraction"});
        q41.setExplanation("For the feature given above, the OOP feature used is Polymorphism. Example of polymorphism in real life is a kid, who can be a student, a son, a brother depending on where he i.");
        q41.setChapter(9);
        dbh.createQuiz(q41);

        Quiz q42 = new Quiz();
        q42.setQuizId(42);
        q42.setDesc("Which of the following is not feature of pure OOP?");
        q42.setRightOption("Data may/may not be declared using object");
        q42.setWrongOptions(new String[]{"Classes must be used", "Inheritance", "Functions Overloading"});
        q42.setExplanation("Data must be declared using objects. Object usage is mandatory because it in turn calls its constructors, which in turn must have a class defined. If object is not used, it is violation of pure OOP concept.");
        q42.setChapter(9);
        dbh.createQuiz(q42);

        Quiz q43 = new Quiz();
        q43.setQuizId(43);
        q43.setDesc("Which among the following doesn’t come under OOP concept?");
        q43.setRightOption("Platform independent");
        q43.setWrongOptions(new String[]{"Data binding", "Message passing", "Data hiding"});
        q43.setExplanation("Platform independence is not feature of OOP. C++ supports OOP but it’s not a platform independent language. Platform independence depends on programming language.");
        q43.setChapter(9);
        dbh.createQuiz(q43);

        Quiz q44 = new Quiz();
        q44.setQuizId(44);
        q44.setDesc("How many basic features of OOP are required for a programming language to be purely OOP?");
        q44.setRightOption("7");
        q44.setWrongOptions(new String[]{"6", "5", "4"});
        q44.setExplanation("There are 7 basic features that define whether a programing language is pure OOP or not. The 4 basic features are inheritance, polymorphism, encapsulation and abstraction. Further, one is, object use is must, secondly, message passing and lastly, Dynamic binding.");
        q44.setChapter(9);
        dbh.createQuiz(q44);

        Quiz q45 = new Quiz();
        q45.setQuizId(45);
        q45.setDesc("OOP provides better security than POP?");
        q45.setRightOption("Always true for any programming language");
        q45.setWrongOptions(new String[]{"May not be true with respect to all programming languages", "It depends on type of program", "It’s vice-versa is true"});
        q45.setExplanation("This is HARD! It is okay if you do not know. It is always true as we have the facility of private and protected access specifiers. Also, only the public and global data is available globally or else program should have proper permission to access the private data.");
        q45.setChapter(9);
        dbh.createQuiz(q45);


        Quiz q46 = new Quiz();
        q46.setQuizId(46);
        q46.setDesc("What is true about private constructor?");
        q46.setRightOption("Private constructor ensures only one instance of a class exist at any point of time");
        q46.setWrongOptions(new String[]{"Private constructor ensures multiple instances of a class exist at any point of time", "Private constructor eases the instantiation of a class", "Private constructor allows creating objects in other classes"});
        q46.setExplanation("Object of private constructor can only be created within class. Private constructor is used in singleton pattern.");
        q46.setChapter(10);
        dbh.createQuiz(q46);

        Quiz q47 = new Quiz();
        q47.setQuizId(47);
        q47.setDesc("What would be the behaviour if this() and super() used in a method?");
        q47.setRightOption("compile time error");
        q47.setWrongOptions(new String[]{"Runtime error", "Throws exception", "Runs successfully"});
        q47.setExplanation("this() and super() cannot be used in a method. This throws compile time error.");
        q47.setChapter(10);
        dbh.createQuiz(q47);

        Quiz q48 = new Quiz();
        q48.setQuizId(48);
        q48.setDesc("What is false about constructor?");
        q48.setRightOption("Constructor can be overloaded");
        q48.setWrongOptions(new String[]{"Constructors cannot be synchronized in Java", "Java does not provide default copy constructor", "'this' and 'super' can be used in a constructor"});
        q48.setExplanation("Default, parameterised constructors can be defined.");
        q48.setChapter(10);
        dbh.createQuiz(q48);

        Quiz q49 = new Quiz();
        q49.setQuizId(49);
        q49.setDesc("What is true about constructor?");
        q49.setRightOption("It can take any number of parameters");
        q49.setWrongOptions(new String[]{"It can contain return type", "It can have any non-access modifiers", "Constructor cannot throw exception"});
        q49.setExplanation("Constructor returns a new object with variables defined as in the class. Instance variables are newly created and only one copy of static variables are created.");
        q49.setChapter(10);
        dbh.createQuiz(q49);

        Quiz q50 = new Quiz();
        q50.setQuizId(50);
        q50.setDesc("What is not the use of “this” keyword in Java?");
        q50.setRightOption("Passing itself to method of the same class");
        q50.setWrongOptions(new String[]{"Passing itself to another method", "Calling another constructor in constructor chaining", "Referring to the instance variable when local variable has the same name"});
        q50.setExplanation("'this' is an important keyword in java. It helps to distinguish between local variable and variables passed in the method as parameters.");
        q50.setChapter(10);
        dbh.createQuiz(q50);

        Quiz q51 = new Quiz();
        q51.setQuizId(51);
        q51.setDesc("Encapsulation and abstraction differ as:");
        q51.setRightOption("Binding and Hiding respectively");
        q51.setWrongOptions(new String[]{"Hiding and Binding respectively", "Can be used any way", "Hiding and hiding respectively"});
        q51.setExplanation("Abstraction is hiding the complex code. For example we directly use cout object in C++ but we don’t know how it is actually implemented. Encapsulation is data binding, as in, we try to combine the similar type of data and functions together.");
        q51.setChapter(11);
        dbh.createQuiz(q51);

        Quiz q52 = new Quiz();
        q52.setQuizId(52);
        q52.setDesc("In terms of stream and files________");
        q52.setRightOption("Abstraction is called a stream and device is called a file");
        q52.setWrongOptions(new String[]{"Abstraction is called a file and device is called a stream", "Abstraction can be called both file and stream", "Abstraction can’t be defined in terms of files and stream"});
        q52.setExplanation("Abstraction is called stream to provide a level of complexity hiding, for how the files operations are actually done. Actual devices are called file because in one way or another, those can be considered as single entity and there is nothing hidden.");
        q52.setChapter(11);
        dbh.createQuiz(q52);

        Quiz q53 = new Quiz();
        q53.setQuizId(53);
        q53.setDesc("Which among the following should be encapsulated?");
        q53.setRightOption("The data which is prone to change is near future");
        q53.setWrongOptions(new String[]{"The data prone to change in long terms", "The data which is intended to be changed", "The data which belongs to some other class"});
        q53.setExplanation("The data prone to change in near future is usually encapsulated so that it doesn’t get changed accidentally. We encapsulate the data to hide the critical working of program from outside world.");
        q53.setChapter(11);
        dbh.createQuiz(q53);

        Quiz q54 = new Quiz();
        q54.setQuizId(54);
        q54.setDesc("If same message is passed to objects of several different classes and all of those can respond in a different way, what is this feature called?");
        q54.setRightOption("Polymorphism");
        q54.setWrongOptions(new String[]{"Inheritance", "Overloading", "Overriding"});
        q54.setExplanation("The feature defined in question defines polymorphism feature. Here the different objects are capable of responding to the same message in different ways, hence polymorphism.");
        q54.setChapter(11);
        dbh.createQuiz(q54);

        Quiz q55 = new Quiz();
        q55.setQuizId(55);
        q55.setDesc("If a function can perform more than 1 type of tasks, where the function name remains same, which feature of OOP is used here?");
        q55.setRightOption("Polymorphism");
        q55.setWrongOptions(new String[]{"Encapsulation", "Inheritance", "Abstraction"});
        q55.setExplanation("For the feature given above, the OOP feature used is Polymorphism. Example of polymorphism in real life is a kid, who can be a student, a son, a brother depending on where he is.");
        q55.setChapter(11);
        dbh.createQuiz(q55);


        Quiz q56 = new Quiz();
        q56.setQuizId(56);
        q56.setDesc("Which among the following best defines abstraction?");
        q56.setRightOption("Hiding the implementation and showing only the features");
        q56.setWrongOptions(new String[]{"Hiding the implementation", "Showing the important data", "Hiding the important data"});
        q56.setExplanation("It includes hiding the implementation part and showing only the required data and features to the user. It is done to hide the implementation complexity and details from the user. And to provide a good interface in programming.");
        q56.setChapter(12);
        dbh.createQuiz(q56);


        Quiz q57 = new Quiz();
        q57.setQuizId(57);
        q57.setDesc("Hiding the implementation complexity can:________");
        q57.setRightOption("Make the programming easy");
        q57.setWrongOptions(new String[]{"Make the programming complex", "Provide more number of features", "Provide better features"});
        q57.setExplanation("It can make the programming easy. The programming need not know how the inbuilt functions are working but can use those complex functions directly in the program. It doesn’t provide more number of features or better features.");
        q57.setChapter(12);
        dbh.createQuiz(q57);

        Quiz q58 = new Quiz();
        q58.setQuizId(58);
        q58.setDesc("Abstraction gives higher degree of ________");
        q58.setRightOption("Idealized interface");
        q58.setWrongOptions(new String[]{"Class usage", "Program complexity", "Unstable interface"});
        q58.setExplanation("It is to idealize the interface. In this way the programmer can use the programming features more efficiently and can code better. It can’t increase the program complexity, as the feature itself is made to hide it.");
        q58.setChapter(12);
        dbh.createQuiz(q58);

        Quiz q59 = new Quiz();
        q59.setQuizId(59);
        q59.setDesc("Abstraction can apply to:");
        q59.setRightOption("Control and data");
        q59.setWrongOptions(new String[]{"Only data", "Only control", "Classes"});
        q59.setExplanation("Abstraction applies to both. Control abstraction involves use of subroutines and control flow abstraction. Data abstraction involves handling pieces of data in meaningful ways.");
        q59.setChapter(12);
        dbh.createQuiz(q59);

        Quiz q60 = new Quiz();
        q60.setQuizId(60);
        q60.setDesc("Abstraction principle includes___________");
        q60.setRightOption("Use abstraction whenever possible to avoid duplication");
        q60.setWrongOptions(new String[]{"Use abstraction at its minimum", "Use abstraction to avoid longer codes", "Use abstraction whenever possible to achieve OOP"});
        q60.setExplanation("Abstraction principle includes use of abstraction to avoid duplication (usually of code). It this way the program doesn’t contain any redundant functions and make the program efficient.");
        q60.setChapter(12);
        dbh.createQuiz(q60);

        Quiz q61 = new Quiz();
        q61.setQuizId(61);
        q61.setDesc("Which among the following best describes encapsulation?");
        q61.setRightOption("It is a way of combining various data members and member functions that operate on those data members into a single unit");
        q61.setWrongOptions(new String[]{"It is a way of combining various data members into a single unit", "It is a way of combining various member functions into a single unit", "It is a way of combining various data members and member functions into a single unit which can operate on any data"});
        q61.setExplanation("It is a way of combining both data members and member functions, which operate on those data members, into a single unit. We call it a class in OOP generally. This feature have helped us modify the structures used in C language to be upgraded into class in C++ and other languages.");
        q61.setChapter(13);
        dbh.createQuiz(q61);

        Quiz q62 = new Quiz();
        q62.setQuizId(62);
        q62.setDesc("If data members are private, what can we do to access them from the class object?");
        q62.setRightOption("Create public member functions to access those data members");
        q62.setWrongOptions(new String[]{"Create private member functions to access those data members", "Create protected member functions to access those data members", "Private data members can never be accessed from outside the class"});
        q62.setExplanation("We can define public member functions to access those private data members and get their value for use or alteration. They can’t be accessed directly but is possible to be access using member functions. This is done to ensure that the private data doesn’t get modified accidentally.");
        q62.setChapter(13);
        dbh.createQuiz(q62);

        Quiz q63 = new Quiz();
        q63.setQuizId(63);
        q63.setDesc("While using encapsulation, which among the following is possible?");
        q63.setRightOption("Data member’s data type can be changed without changing any other code");
        q63.setWrongOptions(new String[]{"Code modification can be additional overhead", "Data member’s type can’t be changed", "Whole code have to be changed Member functions can be used to change the data type of data members"});
        q63.setExplanation("Data member’s data type can be changed without changing any further code. All the members using that data can continue in the same way without any modification. Member functions can never change the data type of same class data members.");
        q63.setChapter(13);
        dbh.createQuiz(q63);

        Quiz q64 = new Quiz();
        q64.setQuizId(64);
        q64.setDesc("Which feature can be implemented using encapsulation?");
        q64.setRightOption("Abstraction");
        q64.setWrongOptions(new String[]{"Inheritance", "Polymorphism", "Overloading"});
        q64.setExplanation("Data abstraction can be achieved by using encapsulation. We can hide the operation and structure of actual program from the user and can show only required information by the user.");
        q64.setChapter(13);
        dbh.createQuiz(q64);

        Quiz q65 = new Quiz();
        q65.setQuizId(65);
        q65.setDesc("In which of the following uses encapsulation?");
        q65.setRightOption("class student{int a; public: void disp(){ cout<<a;} };");
        q65.setWrongOptions(new String[]{"void main(){ int a; void fun( int a=10; cout<<a); fun(); }", "class student{ int a; public: int b;};", "struct topper{ char name[10]; public : int marks; }"});
        q65.setExplanation("It is the class which uses both the data members and member functions being declared inside a single unit. Only data members can be there in structures also. And the encapsulation can only be illustrated if some data/operations are associated within class.");
        q65.setChapter(13);
        dbh.createQuiz(q65);

        Quiz q66 = new Quiz();
        q66.setQuizId(66);
        q66.setDesc("Which of these keyword must be used to inherit a class?");
        q66.setRightOption("extends");
        q66.setWrongOptions(new String[]{"super", "this", "extent"});
        q66.setExplanation("None.");
        q66.setChapter(14);
        dbh.createQuiz(q66);

        Quiz q67 = new Quiz();
        q67.setQuizId(67);
        q67.setDesc("hich of these keywords is used to refer to member of base class from a subclass?");
        q67.setRightOption("super");
        q67.setWrongOptions(new String[]{"upper", "this", "none of the mentioned"});
        q67.setExplanation("Whenever a subclass needs to refer to its immediate superclass, it can do so by use of the keyword super.");
        q67.setChapter(14);
        dbh.createQuiz(q67);

        Quiz q68 = new Quiz();
        q68.setQuizId(68);
        q68.setDesc("A class member declared protected becomes member of subclass of which type?");
        q68.setRightOption("private member");
        q68.setWrongOptions(new String[]{"public member", "protected member", "static member"});
        q68.setExplanation("A class member declared protected becomes private member of subclass.");
        q68.setChapter(14);
        dbh.createQuiz(q68);

        Quiz q69 = new Quiz();
        q69.setQuizId(69);
        q69.setDesc("Which of these is correct way of inheriting class A by class B?");
        q69.setRightOption("class B + class A {}");
        q69.setWrongOptions(new String[]{"class B inherits class A {}", "class B extends A {}", "class B extends class A {}"});
        q69.setExplanation("None.");
        q69.setChapter(14);
        dbh.createQuiz(q69);

        Quiz q70 = new Quiz();
        q70.setQuizId(70);
        q70.setDesc("What is not type of inheritance?");
        q70.setRightOption("Double inheritance");
        q70.setWrongOptions(new String[]{"Single inheritance", "Hierarchical inheritance", "Multiple inheritance"});
        q70.setExplanation("Inheritance is way of acquiring attributes and methods of parent class. Java supports hierarchical inheritance directly.");
        q70.setChapter(14);
        dbh.createQuiz(q70);

        Quiz q71 = new Quiz();
        q71.setQuizId(71);
        q71.setDesc("Which among the following best describes polymorphism?");
        q71.setRightOption("It is the ability for a message/data to be processed in more than one form");
        q71.setWrongOptions(new String[]{"It is the ability for a message/data to be processed in only 1 form", "It is the ability for many messages/data to be processed in one way", "It is the ability for undefined message/data to be processed in at least one way"});
        q71.setExplanation("It is actually the ability for a message / data to be processed in more than one form. The word polymorphism indicates many-forms. So if a single entity takes more than one form, it is known as polymorphism.");
        q71.setChapter(15);
        dbh.createQuiz(q71);

        Quiz q72 = new Quiz();
        q72.setQuizId(72);
        q72.setDesc("What do you call the languages that support classes but not polymorphism?");
        q72.setRightOption("Object-based language");
        q72.setWrongOptions(new String[]{"Class based language", "Procedure Oriented language", "If classes are supported, polymorphism will always be supported"});
        q72.setExplanation("The languages which support classes but doesn’t support polymorphism, are known as object-based languages. Polymorphism is such an important feature, that is a language doesn’t support this feature, it can’t be called as a OOP language.");
        q72.setChapter(15);
        dbh.createQuiz(q72);

        Quiz q73 = new Quiz();
        q73.setQuizId(73);
        q73.setDesc("Which type of function among the following shows polymorphism?");
        q73.setRightOption("Virtual function");
        q73.setWrongOptions(new String[]{"Inline function", "Undefined functions", "Class member functions"});
        q73.setExplanation("Only virtual functions among these can show polymorphism. Class member functions can show polymorphism too but we should be sure that the same function is being overloaded or is a function of abstract class or something like this, since we are not sure about all these, we can’t say whether it can show polymorphism or not.");
        q73.setChapter(15);
        dbh.createQuiz(q73);


        Quiz q74 = new Quiz();
        q74.setQuizId(74);
        q74.setDesc("In case of using abstract class or function overloading, which function is supposed to be called first?");
        q74.setRightOption("Function with highest priority in compiler");
        q74.setWrongOptions(new String[]{"Local function", "Global function", "Function with lowest priority because it might have been halted since long time, because of low priority"});
        q74.setExplanation("Function with highest priority is called. Here, it’s not about the thread scheduling in CPU, but it focuses on whether the function in local scope is present or not, or if scope resolution is used in some way, or if the function matches the argument signature. So all these things define which function has the highest priority to be called in runtime. Local function could be one of the answer but we can’t say if someone have used pointer to another function or same function name.");
        q74.setChapter(15);
        dbh.createQuiz(q74);

        Quiz q75 = new Quiz();
        q75.setQuizId(75);
        q75.setDesc("Which among the following can’t be used for polymorphism?");
        q75.setRightOption("Static member functions");
        q75.setWrongOptions(new String[]{"Member functions overloading", "Predefined operator overloading", "Constructor overloading"});
        q75.setExplanation("Static member functions are not property of any object. Hence it can’t be considered for overloading/overriding. For polymorphism, function must be property of object, not only of class.");
        q75.setChapter(15);
        dbh.createQuiz(q75);

        Quiz q76 = new Quiz();
        q76.setQuizId(76);
        q76.setDesc("When does Exceptions in Java arises in code sequence?");
        q76.setRightOption("Run Time");
        q76.setWrongOptions(new String[]{"Compilation Time", "Can Occur Any Time", "None of the mentioned"});
        q76.setExplanation("Exceptions in java are run-time errors.");
        q76.setChapter(16);
        dbh.createQuiz(q76);

        Quiz q77 = new Quiz();
        q77.setQuizId(77);
        q77.setDesc("Which of these keywords is not a part of exception handling?");
        q77.setRightOption("thrown");
        q77.setWrongOptions(new String[]{"try", "finally", "catch"});
        q77.setExplanation("Exceptional handling is managed via 5 keywords – try, catch, throws, throw and finally.");
        q77.setChapter(16);
        dbh.createQuiz(q77);

        Quiz q78 = new Quiz();
        q78.setQuizId(78);
        q78.setDesc("Which of these keywords must be used to monitor for exceptions??");
        q78.setRightOption("try");
        q78.setWrongOptions(new String[]{"finally", "throw", "catch"});
        q78.setExplanation("None.");
        q78.setChapter(16);

        dbh.createQuiz(q78);
        Quiz q79 = new Quiz();
        q79.setQuizId(79);
        q79.setDesc("Which of these keywords must be used to handle the exception thrown by try block in some rational manner?");
        q79.setRightOption("catch");
        q79.setWrongOptions(new String[]{"try", "finally", "throw"});
        q79.setExplanation("If an exception occurs within the try block, it is thrown and cached by catch block for processing.");
        q79.setChapter(16);
        dbh.createQuiz(q79);

        Quiz q80 = new Quiz();
        q80.setQuizId(80);
        q80.setDesc("Which of these keywords is used to manually throw an exception?");
        q80.setRightOption("throw");
        q80.setWrongOptions(new String[]{"try", "finally", "catch"});
        q80.setExplanation("None.");
        q80.setChapter(16);
        dbh.createQuiz(q80);

        chaNum = position + 1;

        quizzes = dbh.getAllCategory(chaNum);
        mTv_id.setText(String.valueOf(quizNum + 1) + ". ");
        mTv_description.setText(quizzes.get(quizNum).getDesc());


        if (rint == 0) {
            mRb_1.setText(quizzes.get(quizNum).getRightOption());
            wrongOptions = quizzes.get(quizNum).getWrongOptions();
            mRb_2.setText(wrongOptions[0]);
            mRb_3.setText(wrongOptions[1]);
            mRb_4.setText(wrongOptions[2]);
        } else if (rint == 1) {
            mRb_2.setText(quizzes.get(quizNum).getRightOption());
            wrongOptions = quizzes.get(quizNum).getWrongOptions();
            mRb_1.setText(wrongOptions[0]);
            mRb_3.setText(wrongOptions[1]);
            mRb_4.setText(wrongOptions[2]);
        } else if (rint == 2) {
            mRb_3.setText(quizzes.get(quizNum).getRightOption());
            wrongOptions = quizzes.get(quizNum).getWrongOptions();
            mRb_1.setText(wrongOptions[0]);
            mRb_2.setText(wrongOptions[1]);
            mRb_4.setText(wrongOptions[2]);
        } else if (rint == 3) {
            mRb_4.setText(quizzes.get(quizNum).getRightOption());
            wrongOptions = quizzes.get(quizNum).getWrongOptions();
            mRb_1.setText(wrongOptions[0]);
            mRb_2.setText(wrongOptions[1]);
            mRb_3.setText(wrongOptions[2]);
        }

         if (quizNum != 4){
            mBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mBtn.setText("Next");
                    mBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(QuizActivity.this, QuizActivity.class);
                            intent.putExtra("quizNum", quizNum + 1);
                            intent.putExtra("pos", position);
                            if (right_wrong == true) {
                                right = right + 1;
                                intent.putExtra("right", right);
                            } else {
                                intent.putExtra("right", right);
                            }
                            System.out.println(right + "look at here");
                            startActivity(intent);
                        }
                    });
                    if (rint == 0) {
                        if (mRb_1.isChecked()) {
                            mIv.setImageResource(R.mipmap.right);
                            right_wrong = true;
                        } else {
                            mIv.setImageResource(R.mipmap.wrong);
                            mTv_ex.setText(quizzes.get(quizNum).getExplanation());
                            right_wrong = false;
                        }
                    } else if (rint == 1) {
                        if (mRb_2.isChecked()) {
                            mIv.setImageResource(R.mipmap.right);
                            right_wrong = true;
                        } else {
                            mIv.setImageResource(R.mipmap.wrong);
                            mTv_ex.setText(quizzes.get(quizNum).getExplanation());
                            right_wrong = false;
                        }
                    } else if (rint == 2) {
                        if (mRb_3.isChecked()) {
                            mIv.setImageResource(R.mipmap.right);
                            right_wrong = true;
                        } else {
                            mIv.setImageResource(R.mipmap.wrong);
                            mTv_ex.setText(quizzes.get(quizNum).getExplanation());
                            right_wrong = false;
                        }
                    } else if (rint == 3) {
                        if (mRb_4.isChecked()) {
                            mIv.setImageResource(R.mipmap.right);
                            right_wrong = true;
                        } else {
                            mIv.setImageResource(R.mipmap.wrong);
                            mTv_ex.setText(quizzes.get(quizNum).getExplanation());
                            right_wrong = false;
                        }
                    }
                }
            });
        } else {
             mBtn.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     mBtn.setText("Done");
                     mBtn.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View view) {
                             Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                             if (right_wrong == true) {
                                 right = right + 1;
                                 intent.putExtra("right", right);
                             } else {
                                 intent.putExtra("right", right);
                             }


                             startActivity(intent);
                         }
                     });
                     if (rint == 0) {
                         if (mRb_1.isChecked()) {
                             mIv.setImageResource(R.mipmap.right);
                             right_wrong = true;
                         } else {
                             mIv.setImageResource(R.mipmap.wrong);
                             mTv_ex.setText(quizzes.get(quizNum).getExplanation());
                             right_wrong = false;
                         }
                     } else if (rint == 1) {
                         if (mRb_2.isChecked()) {
                             mIv.setImageResource(R.mipmap.right);
                             right_wrong = true;
                         } else {
                             mIv.setImageResource(R.mipmap.wrong);
                             mTv_ex.setText(quizzes.get(quizNum).getExplanation());
                             right_wrong = false;
                         }
                     } else if (rint == 2) {
                         if (mRb_3.isChecked()) {
                             mIv.setImageResource(R.mipmap.right);
                             right_wrong = true;
                         } else {
                             mIv.setImageResource(R.mipmap.wrong);
                             mTv_ex.setText(quizzes.get(quizNum).getExplanation());
                             right_wrong = false;
                         }
                     } else if (rint == 3) {
                         if (mRb_4.isChecked()) {
                             mIv.setImageResource(R.mipmap.right);
                             right_wrong = true;
                         } else {
                             mIv.setImageResource(R.mipmap.wrong);
                             mTv_ex.setText(quizzes.get(quizNum).getExplanation());
                             right_wrong = false;
                         }
                     }
                 }
             });
         }


        //SQLiteDatabase db = new DatabaseHelper(QuizActivity.this).getWritableDatabase();
        //quizzes = dbh.getAllCategory(1999);
        //mTv.setText(String.valueOf(quizzes.get(0).getChapter()));
        //Log.i("DATABASE SETTING", quizzes.get(0).getChapter());
        //mTv.setText(quizzes.get(0).getChapter());
        //List<Quiz> quizes = new ArrayList<Quiz>();
        //quizes.add(q1);
        //mTv.setText(quizes.get(0).getChapter());
        //System.out.println(quizzes.get(0).getChapter());
    }
}
