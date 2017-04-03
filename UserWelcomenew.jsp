<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>

<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>

<script>
$(document).ready(function(){
	
	$("#stTable").hide(); 
	$("#showTrips").hide(); 
	$("#showTripsforplanning").hide();
	
    $("#but1").click(function(){
        
        $("#stTable").show(); 
        $("#showTrips").hide();
        $("#showTripsforplanning").hide();
      
    });
    
	$("#but2").click(function(){
        
        $("#showTrips").show(); 
        $("#stTable").hide();
        $("#showTripsforplanning").hide();
      
    });
	
	$("#but3").click(function(){
        
        $("#showTrips").hide(); 
        $("#stTable").hide();
        $("#showTripsforplanning").show();
      
    });
    
    $("#viewTrips").click(function(){
       alert("in view trips");
    });
});


</script>

<title>Struts 2 - Login Application </title>
</head>
 

<body>
    <h2> Welcome <s:property  value="hiddenemail" />...!</h2>
    
 
<table style="width:100%">
  <tr>

  <th>
   
   <button id="but1" name="button1" onclick="myFunction()"> Plan the Trip </button>
 </th>		
    
   <th>
   
  <button id="but2" name="button2" onclick="myFunction1()"> View Trips </button>
 
 </th>
 <th> 
 
 <button id="but3" name="button3" onclick="myFunction2()"> Plan Trips </button>

</th>
 
 <th> 
 
 <s:form action="logout.action" method="post">

    	<s:submit method="execute" key="logout" value="Log Out" align="center" />
</s:form> 

</th>
 
  </tr>

</table>

<s:actionerror />
 
    <s:form id="tripform" action="trip.action" method="post" >
    
     <table id="stTable">
     <tr>
     <td>
     
	
	<s:hidden  name = "hiddenemail"  value="%{hiddenemail}"/> 
	
   <s:property value = "hiddenemail"  /> 
	<s:textfield name="tripId" key="Trip ID"  size="50" align="center"/>
       		 <s:textfield name="tripName" key="Name Of the Trip" size="50" />
          		<s:textfield name="tripDescription" key="Describe the trip shortly" size="100" />
         			 <s:textfield name="when" key="Date" value="2015-12-25" size="50" />
           				 <s:textfield name="venue" key="Venue" size="20" />
            				<s:textfield name="time" key="Time" value="hh:mm:ss" size="10" />
            					<s:radio name="tripStatus" key=" Trip Status " list="{'Open For Registration','closed','cancelled','completed'}" />
      								<s:radio name="invitedlist" key=" Invite " list="{'all','select teams'}" />
      					</td>
      					<td id="shteams">
									<s:iterator value="teams" var="val">
									
									<s:checkbox  fieldValue="%{#val.team}" name="teamname" label="%{#val.team}"/>

									</s:iterator> 
									
									<%-- <s:checkboxlist name="teamname" list="teams" />  --%>
									
									</td>
			</tr>
	<s:submit method="execute" key="Register the Trip " value="Confirm the Trip" align="center" />	
   
            
   </table>            

</s:form> 

<table id="showTrips"  style="width:100%">
<tr>
	 <th>Trip Id</th>
	
	<th>Trip Name</th>
	
	<th> Trip Description </th>
	
	<th> Venue </th>
	<th> Time </th>
	<th> Trip Status </th>
	<th> Date </th>
	<th> Invited List </th>
	<th> Created By </th>
	<th> REGISTER </th> 
	
	</tr> 
	
	<tr>
<s:iterator value="tripInfo" var="tf">

<tr>
<td><s:property value="#tf.tripid"/></td>
<td><s:property value="#tf.tripname"/></td>
<td><s:property value="#tf.tripdesc"/></td>
<td><s:property value="#tf.venue"/></td>
<td><s:property value="#tf.time"/></td>
<td><s:property value="#tf.tripstatus"/></td>
<td><s:property value="#tf.when"/></td>
<td><s:property value="#tf.invitedlist"/></td>
<td><s:property value="#tf.email"/></td>

 <td> 
 
 <s:form action="userstatus.action">
 
	<s:hidden    name = "hiddenemail"  value="%{hiddenemail}"/>
 	<s:hidden name="tripid" value="%{#tf.tripid}" />
	
	<s:radio name="userstatus"  list="{'coming','Not Coming'}" />
	
	<%-- <s:checkbox  fieldValue="%{#tf.tripid}" name="usercoming" label="coming"/>
	<s:checkbox  fieldValue="%{#tf.tripid}" name="userNotcoming" label="Not coming"/> --%>
 	
<s:submit key="Confirm" value="Confirm" align="center"/>
</s:form>		 
		 </td>
 </s:iterator>
 <s:iterator value="tripInfowithuserstatus" var="tfwus">

<tr>
<td><s:property value="#tfwus.tripid"/></td>
<td><s:property value="#tfwus.tripname"/></td>
<td><s:property value="#tfwus.tripdesc"/></td>
<td><s:property value="#tfwus.venue"/></td>
<td><s:property value="#tfwus.time"/></td>
<td><s:property value="#tfwus.tripstatus"/></td>
<td><s:property value="#tfwus.when"/></td>
<td><s:property value="#tfwus.invitedlist"/></td>
<td><s:property value="#tfwus.email"/></td> 

 <td> 
 
 <s:form action="userstatus.action">
 
	<s:hidden    name = "hiddenemail"  value="%{hiddenemail}"/>
	<s:hidden name="tripid" value="%{#tfwus.tripid}" />
	
	<s:radio name="userstatus"  list="{'coming','Not Coming'}" value="%{#tfwus.userstatus}" />

<s:submit key="Confirm" value="Confirm" align="center"/>
</s:form>	

		 </td>
 
</tr>
</s:iterator>

</table>

<s:actionerror />

<!-- ............................................................................................... -->



<table id="showTripsforplanning"  style="width:100%">
<tr>
	 <th>Trip Id</th>
	
	<th>Trip Name</th>
	
	<th> Trip Description </th>
	
	<th> Venue </th>
	<th> Time </th>
	<th> Trip Status </th>
	<th> Date </th>
	<th> Invited List </th>
	
	<th> REGISTER </th> 
	
	</tr> 
	
	<tr>
<s:iterator value="tripInfoforPlanning" var="tfp">

<tr>
<td><s:property value="#tfp.tripid"/></td>
<td><s:property value="#tfp.tripname"/></td>
<td><s:property value="#tfp.tripdesc"/></td>
<td><s:property value="#tfp.venue"/></td>
<td><s:property value="#tfp.time"/></td>
<td><s:property value="#tfp.tripstatus"/></td>
<td><s:property value="#tfp.when"/></td>
<td><s:property value="#tfp.invitedlist"/></td>


 <td> 
 
 <s:form action="plan.action">
 
	<s:hidden    name = "hiddenemail"  value="%{hiddenemail}"/>
	
	<s:hidden name="tripid" value="%{#tfp.tripid}" />
	
	

<s:submit key="Plan" value="Plan" align="center"/>
</s:form>	

		 </td>
</s:iterator>		 
</tr>
</table>
</body>
</html>