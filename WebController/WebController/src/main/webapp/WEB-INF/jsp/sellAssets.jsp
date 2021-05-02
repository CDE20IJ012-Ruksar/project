<%@ page language="java" contentType="text/html;  charset=UTF-8"
import="java.util.*"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>

  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="style/sellAssets-style.css">
    <title>Sell Assets</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg  navbar-dark bg-dark">
  <a class="navbar-brand" href="#" style="margin-left: 20px; margin-right:450px;">
          <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjxGDl9hG7JE2Z4YhCgE3D2P4rjn0f0jRiXA&usqp=CAU" width="30" height="30" class="d-inline-block align-top" alt="">
            Portfolio Manager</a>
  
	<button class="navbar-toggler" data-toggle="collapse" data-target="#navbarmenu">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarmenu">

      <ul class="navbar-nav ml-auto">
		<li class="nav-item active">
        <form action="/Home" >
			<button type="button float-right" style="margin-right: 30px;" class="btn btn-outline-light">HOME</button>
		</form>
         </li>
         <li class="nav-item">
        <form action="/viewportfolio" >
			<button type="button float-right" style="margin-right: 30px;"
				class="btn btn-outline-light">PORTFOLIO</button>
		</form>
      </li>
		<li class="nav-item">
        <form action="/viewNetworth" >
			<button type="button float-right" style="margin-right: 30px;"
				class="btn btn-outline-light">NETWORTH</button>
		</form>
      </li>
      </li>
		<li class="nav-item">
        <form action="/sellAssets" >
			<button type="button float-right" style="margin-right: 30px;"
				class="btn btn-outline-light">SELL</button>
		</form>
      </li>
      <li class="nav-item active" >
        <form action="/logout" method="GET" >
			<button type="button float-right" style="margin-right: 20px;"
				class="btn btn-outline-light">LOGOUT</button>
		</form>
 	</li>
	
	
	
</ul>
  </div>
</nav>	
      <br>
      <div class="container">
        <div class="row">
            <div class="col-sm-3"></div>
            <div class="col-sm-6 ">
                <div class="card text-center shadow-lg">
                    <img class="card-img-top img-fluid" src="https://previews.123rf.com/images/nesdesign/nesdesign1803/nesdesign180300002/97015699-sell-property-and-building-asset-for-investment-business-concept-3d-rendering.jpg" style="width:600x;height:300px;" alt="Card image cap">
                    <div class="card-block">
                        <h4 class="card-title">Sell Assets</h4>
                        <p class="card-text">Select the assets which you want to sell.</p>
                     <!--   	<select id="lstFruits" multiple="multiple">
                      	<c:forEach items="${asset}" var="temp">
                        <option>${temp.assetid}</option>
                        <p> ${ fn:length(assets)}</p>
                        </c:forEach>
                        </select>    -->
                        
                        
                     <%--    
                        <% Map<String,Integer> stockIdList=new HashMap<String,Integer>();
                        Map<String,Integer> mfAssetList=new HashMap<String,Integer>();                        
                        %>
                        <% if(${temp.type}=="MF"){
                        	stockIdList.put(temp.assetid,temp.units);
                        }
                        else{stockIdList.put(temp.assetid,temp.units);}
                        %> 
                        --%>
                     <!--    <form:form action="/viewNetworth" method="POST" modelAttribute="SellObjectMap">
                         <c:forEach items="${asset}" var="temp" >
                         <input type="checkbox" id="${temp.assetid}" name="${temp.assetid}">${temp.assetid } &nbsp;&nbsp;&nbsp;<input type="number" id="quantity" name="quantity" min="1" max="${temp.units}"><br> 
                         </c:forEach>
                         
                         
                         </form:form> --> 
                         <%-- List<String> l=new ArrayList<>(); --%>
                         <form method="post" onSubmit=" return checker();" action="/viewNetworth" >
                         <table border="1" class=table style="margin-left: auto;margin-right: auto;">
                			<tr>
                    			<th scope=col>Asset ID</th>
                    			<!-- <th scope=col>Asset Name</th> -->
                    			<th scope=col>Asset Type</th>
                    			<th scope=col>Number of units you hold</th>
                    			<th scope=col>Units to be sold</th>
                         	<tr>
                         	<c:forEach items="${asset}" var="temp" >
                        <tr>
                         <td scope=row><input type="checkbox" value="${temp.assetid}" name="selected">${temp.assetid }</td>
                         <%-- <td scope=row>${temp.assetname}</td> --%>
                         <td scope=row>${temp.type}</td>
                         <td scope=row>${temp.units}</td>
                         <td scope=row><input  type="number" id="quantity" name="quantity" value="0" min="0" max="${temp.units}"></td> 
                         </c:forEach>
                         </tr>
                         </table>
                         
                         <button type="submit" name="submit"  class="btn btn-black btn-secondary" style="margin-bottom:10px;">NETWORTH</button>
                         </form>     
       
                         
                         
                         
                    </div>
                </div>
            </div>
            <script type="text/javascript" >
            	var a=document.getElementById("quantity")
            	function checker(){
                	var count=0;
					var l = document.getElementsByName("selected");
					for(var i=0;i<l.length;i++){
						if(l[i].checked)count++;
					}
					//console.log(count);
					 if(count==0){
						alert("Please select a value");
						return false;
					}else return true; 	
                }
            </script>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
            
</body>
</html>