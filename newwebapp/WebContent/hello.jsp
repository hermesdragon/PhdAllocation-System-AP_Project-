<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<html>
  <head>
    <title>Tab_1</title>
  </head>
  <body>


     <script>
    function showDiv(obj) {
      debugger
        if (obj.checked) {
            document.getElementById('content').innerHTML = 
'<h2>ECE PhD Subject Preference</h2><h5>You are required to select 4 subjects if you are an under-graduate otherwise you need to fill 3.</h5>'+
'Preference 1* <select name="P1" required >'+
        '<option selected>Please Select</option>'+
        '<option value="Advanced Signal Processing">Advanced Signal Processing</option>'+
        '<option value="Statistical Signal Processing">Statistical Signal Processing</option>'+
        '<option value="Digital VLSI Design">Digital VLSI Design</option>'+
        '<option value="Analog CMOS design">Analog CMOS design</option>'+
        '<option value="Digital Communications">Digital Communications</option>'+
        '<option value="Communication Networks">Communication Networks</option>'+
        '<option value="Linear systems">Linear systems</option>'+
        '<option value="Introduction to Robotics">Introduction to Robotics</option>'+
        '</select><br>'+
'Preferenc2*<select name="P2" required >'+
'<option selected>Please Select</option>'+
'<option value="Advanced Signal Processing">Advanced Signal Processing</option>'+
'<option value="Statistical Signal Processing">Statistical Signal Processing</option>'+
'<option value="Digital VLSI Design">Digital VLSI Design</option>'+
'<option value="Analog CMOS design">Analog CMOS design</option>'+
'<option value="Digital Communications">Digital Communications</option>'+
'<option value="Communication Networks">Communication Networks</option>'+
'<option value="Linear systems">Linear systems</option>'+
'<option value="Introduction to Robotics">Introduction to Robotics</option>'+
'</select><br>'+
'Preference 3*<select name="P3" required >'+
'<option selected>Please Select</option>'+
'<option value="Advanced Signal Processing">Advanced Signal Processing</option>'+
'<option value="Statistical Signal Processing">Statistical Signal Processing</option>'+
'<option value="Digital VLSI Design">Digital VLSI Design</option>'+
'<option value="Analog CMOS design">Analog CMOS design</option>'+
'<option value="Digital Communications">Digital Communications</option>'+
'<option value="Communication Networks">Communication Networks</option>'+
'<option value="Linear systems">Linear systems</option>'+
'<option value="Introduction to Robotics">Introduction to Robotics</option>'+
'</select><br>'+
'Preference 4<select name="P4">'+
'<option selected>Please Select</option>'+
'<option value="Advanced Signal Processing">Advanced Signal Processing</option>'+
'<option value="Statistical Signal Processing">Statistical Signal Processing</option>'+
'<option value="Digital VLSI Design">Digital VLSI Design</option>'+
'<option value="Analog CMOS design">Analog CMOS design</option>'+
'<option value="Digital Communications">Digital Communications</option>'+
'<option value="Communication Networks">Communication Networks</option>'+
'<option value="Linear systems">Linear systems</option>'+
'<option value="Introduction to Robotics">Introduction to Robotics</option>'+
'</select><br>';
            }
            else {
                document.getElementById('content').innerHTML = '';
            }
    }
    function showDiv1(obj) {
        debugger
        if (obj.checked) {
            document.getElementById('content1').innerHTML ='Name of College <input type="text" name="pgclg"><br>'
            +'City<input type="text" name="pgcity"><br>' 
            +'State'+
      '<select name="pgstate">'+
        '<option selected>Please Select</option>'+
        '<option>Delhi</option>'+
        '<option>Mumbai</option>'+
        '<option>Chennai</option>'+
        '<option>Kolkata</option>'+
        '<option>Utter Pradesh</option>'+
        '<option>Himachal</option>'+
        '<option>Sikkim</option>'+
        '</select><br>'+            
            'Department/Discipline <input type="text" name="pgdepart"><br>'
            +'Degree <input type="text" name="pgdeg"><br>'
            +'Thesis Title <input type="text" name="pgthesis"><br>'
            +'Year of Post-Graduation*<input type="number" name="pgyear" min="1906" max="2015" required ><br>'
+'CGPA or MARKS?'
+'<input type="radio" name="cm1" value="Cgpa">Cgpa<br>'
+'<input type="number" name="Cgpa1" min="1" max="10"><br>'
+'<input type="radio" name="cm1" value="Marks">Marks<br>'
+'<input type="number" name="Marks1" min="1" max="100"><br>';
            
        }
            else {
                document.getElementById('content1').innerHTML = '';
            }
        }
    function showDiv2(obj) {
        debugger
        if (obj.checked) {
            document.getElementById('content2').innerHTML = 'Exam Name <input type="text" name="otherexam"><br>'+ 
            'Subject <input type="text" name="othersub"><br>'+
            'Year*<input type="number" name="otheryear" min="1996" max="2015" required><br>'+
            'Score <input type="number" name="otherscore" max="100" min="1"><br>'+
            'Rank<input type="number" name="otherrank" max="100" min="1"><br>';
            
            }
            else {
                document.getElementById('content2').innerHTML = '';
            }
        }
    function showDiv3(obj) {
        debugger
        if (obj.checked) {
            document.getElementById('content3').innerHTML = 'Area<input type="text" name="gatearea"><br>'+  
            'Year of Graduation*<input type="number" name="gateyear" min="1996" max="2015" required><br>'+
            'Marks(Out Of 100) <input type="number" name="gatemarks" min="1" max="100"><br>'+
            'Score <input type="number" name="gatescore" min="1" max="100"><br>'+
            'Rank<input type="number" name="gaterank" min="1" max="100"><br>';
            }
            else {
                document.getElementById('content3').innerHTML = '';
            }
        } 
</script>


  <form name="myForm" action="IIITDAdmission"  method="post">
  <h1>Client Side</h1>
      Email&nbsp*:&nbsp
          <input name='email' type='email' required="true"/>
          <br><br>
          Name &nbsp *: &nbsp 
          <input name='name' type='text' required="true"/>
          <br><br>  
          Enrollment &nbsp Number &nbsp *: &nbsp 
          <% 
      ArrayList<Integer>l=new ArrayList<Integer>();
      int min = 2014000;
      int max =2015000;
      Random r=new Random();
      int i1 = r.nextInt(max - min + 1) + min;
      while(l.contains(i1))
      i1 = r.nextInt(max - min + 1) + min;
      l.add(i1);
      %>
          <input name='id' type='text' value = "<%out.println(i1);%>" readonly />
          <br><br>
          Address &nbsp Of &nbsp Correspondence &nbsp *: &nbsp 
          <input name='address' type='text' required="true"/>
          <br><br>
          Mobile &nbsp Number &nbsp *: &nbsp
          <input name='mobile' type='number' min='1000000000' max='9999999999' required="true"/>
          <br><br>
          PhD &nbsp Stream &nbsp *: &nbsp 
          <input name='phdstream' type='radio' value='Computer Science' required='true' />Computer Science
          <input name='phdstream' type='radio' value='Electronics' required='true' />Electronics and Communication
          <input name='phdstream' type='radio' value='Biology' required='true' />Computational Biology
          <br><br>
          Phd Pref 1*:&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
            <select name="cat" required="true">
            <option>---</option>
              <option value="bio">Biophysics</option>
              <option value="compl">Compilers</option>
              <option value="cg">Computer Graphics</option>
              <option value="ic">Integrated Circuits</option>
            </select><br><br>
          Phd Pref 2:&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
            <select name="dog">
            <option>---</option>
              <option value="bio">Biophysics</option>
              <option value="compl">Compilers</option>
              <option value="cg">Computer Graphics</option>
              <option value="ic">Integrated Circuits</option>
            </select><br><br>
          Phd Pref 3:&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
            <select name="lion">
              <option>---</option>
              <option value="bio">Biophysics</option>
              <option value="compl">Compilers</option>
              <option value="cg">Computer Graphics</option>
              <option value="ic">Integrated Circuits</option>
            </select><br><br>
            Gender*: &nbsp &nbsp
          <input name='gender' type='radio' value='Male' required="true"/>Male
          <input name='gender' type='radio' value='Female' required="true"/>Female
          <br></br>
          Category*:&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
            <input name='categ' type='radio' value='GEN' required="true"/>GEN
            <input name='categ' type='radio' value='SC'  required="true"/>SC
            <input name='categ' type='radio' value='ST'  required="true"/>ST
            <input name='categ' type='radio' value='OBC'  required="true"/>OBC
            <br><br>
          Physically Disabled*: &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
            <input name='phys' type='radio' value='Yes' required="true"/>Yes
            <input name='phys' type='radio' value='No' required="true"/>No
            <br></br>
          Date of Birth*: &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
            <input type="date" name="dob" required="true">
          <br></br>
          Children/War widows/Disabled in action*: &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
            <input name='war' type='radio' value='Yes' required="true"/>Yes
            <input name='war' type='radio' value='No' required="true"/>No
          <br></br>
          Fathers Name*:  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
            <input name='fatname' type='text' required="true"/>
          <br></br>
          Nationality*:  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
            <select name="nation" required="true">
              <option>---</option>
              <option value="ind">India</option>
              <option value="amer">America</option>
              <option value="aus">Austalia</option>
              <option value="pak">Pakistan</option>
            </select><br><br>
          Permanent Address *:  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          <input name='permaddress' type='text' required="true"/>
          <br></br>
          Pin Code *:  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          <input name='pin' type='number' required="true"/>
          <br></br>
          <h2> Schooling Information</h2>
            
          Xth Board *:  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          <input name='xboard' type='text' required="true"/>
          <br></br>
          Xth Marks(%) *:  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          <input name='xmarks' type='number' required="true" min="1" max="100"/>
          <br></br>
          Year Of Passing Xth *:  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          <select name="xpass" required="true">
              <option>---</option>
              <option value="13">2013</option>
              <option value="12">2012</option>
              <option value="11">2011</option>
              <option value="10">2010</option>
            </select><br><br>
          XIIth Board *:  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          <input name='xiiboard' type='text' required="true"/>
          <br></br>
          XIIth Marks(%) *:  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          <input name='xiimarks' type='nummber' required="true" min="1" max="100"/>
          <br></br>
          Year Of Passing XIIth *:  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          <select name="xiipass" required="true">
              <option>---</option>
              <option value="15">2015</option>
              <option value="14">2014</option>
              <option value="13">2013</option>
              <option value="12">2012</option>
            </select><br><br>
          <h2> Graduation Information</h2>

          Degree *:  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          <input name='graddeg' type='text' required="true"/>
          <br></br>
          Department/Discipline *:  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          <input name='graddepart' type='text' required="true"/>
          <br></br>'
          Name Of College *:  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          <input name='gradclg' type='text' required="true"/>
          <br></br>
          Graduation University *:  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          <input name='graduniv' type='text' required="true"/>
          <br></br>
          City *:  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          <input name='gradcity' type='text' required="true"/>
          <br></br>
          State *:  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          <select name="gradstate" required="true">
              <option>---</option>
              <option value="delhi">Delhi</option>
              <option value="rajasthan">Rajasthan</option>
              <option value="bihar">Bihar</option>
              <option value="maharashtra">Maharashtra</option>
            </select><br><br>
          Year Of Graduation *:  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          <select name="gradyear" required="true">
              <option>---</option>
              <option value="15">2015</option>
              <option value="14">2014</option>
              <option value="13">2013</option>
              <option value="12">2012</option>
            </select><br><br>
          CGPA/Marks *:  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          CGPA(Out of 10)<input name='graddcore' type='radio' value='cgpa' required="true"/> &nbsp &nbsp &nbsp &nbsp
          <input name='gradcgpa' type='number' min="1" max="10"/>
          <br>
          Marks <input name='graddcore' type='radio' value='marks' required="true"/> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          <input name='gradmarks' type='number' min="1" max="100"/>
          <br>
          <input type="checkbox" onchange="showDiv(this)">Are you applying for ECE PhD?<br>
<div id="content">

</div>
<br>
<input type="checkbox" onchange="showDiv1(this)">Have you completed your Post Graduation?
<div id="content1">

</div>
<br>
<input type="checkbox" onchange="showDiv2(this)">Other Academic Degrees?
<div id="content2">

</div>
<br>
<input type="checkbox" onchange="showDiv3(this)">Taken GATE Exam?
<div id="content3">

</div>

         <h3>CV/Resume*:</h3>
                  <br />
                  <!--<form action="UploadServlet" method="post" enctype="multipart/form-data">-->
                  <input type="file" name="file1" size="50" required/>
                  <br />
                <h3>Statement of Purpose*</h3>
                  <br />
                  <!--<form action="UploadServlet" method="post" enctype="multipart/form-data">-->
                  <input type="file" name="file2" size="50" required/>
                  <br />
                <br><br>
          Submit :
            <input type = "submit" name = "go">
            </form>

  </body>
  </html>