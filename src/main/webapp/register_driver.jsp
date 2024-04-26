
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Driver</title>
         <%@include file="componenets/common_css_js.jsp"%>
                 <%@include file="componenets/navbar.jsp" %>
    </head>
    <body>
        <div class="container-fluid">
               <div class="row mt-5">
            <div class="col-md-6 offset-md-3">
                <div class="card">
                    <%@include file="componenets/message.jsp" %>         
                <div class="card-body px-5">
                    
                          <div style="text-align: center;">
                              <img src="image/logo-color.png" height="300" width="300" >
                          </div>
                     <h3 class="text-center my-3">  Sign up here !!</h3>  
                <form action="RegisterServlet"method="post">

  <div class="form-group">
    <label for="name">driver Name</label>
    <input name="driver_name" type="text" class="form-control" id="name" placeholder="Enter here"aria-describedby="name">
  </div>
                    <div class="form-group">
    <label for="email">driver Email</label>
    <input name="driver_email" type="text" class="form-control" id="email" placeholder="Enter here"aria-describedby="email">
  </div>
                        <div class="form-group">
    <label for="password">User Password</label>
    <input name="driver_password" type="password" class="form-control" id="password" placeholder="Enter here"aria-describedby="password">
  </div>
       <div class="form-group">
     <label for="phone">driver Phone</label>
    <input name="driver_phone" type="number" class="form-control" id="phone" placeholder="Enter here"aria-describedby="phone">
    
  </div>
  <div class="form-group">
     <label for="address">driver Address</label>
     <textarea name="driver_address" style="height:100px;" class="form-control" placeholder="Enter here"></textarea>
  </div>
                    <div class="form-group">
     <label for="licence_no">driver Licence</label>
     <input name="driver_licence" type="text" class="form-control" id="licence" placeholder="Enter here"></input>
  </div>
               <div class="form-group">
     <label for="bike_no">vehicles number</label>
     <input name="driver_licence" type="text" class="form-control" id="bike" placeholder="Enter here"></input>
  </div>
                        <div class="form-group">
<label for="imageUpload">Select an image:</label> 
  <input type="file" id="imagedriver" name="imagedriver"> 
  <input type="submit" value="Upload"> 
              </div>

          
                    <div class="container text-center">
                        <button class="btn btn-outline-success">Register</button>
                         <button class="btn btn-outline-warning">Reset</button>

                </form>
                </div>
            </div>
        </div>
            </div>
            </div>
        </div>
    </body>
</html>
