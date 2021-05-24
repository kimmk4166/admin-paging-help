<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>스케쥴 데이터를 입력하세요</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

        <script>
            $(function () {
            	$("#datepicker1").datepicker({ dateFormat: "yy-mm-dd" }).val()
                $("#datepicker1").datepicker();
            });
            $(function () {
            	$("#datepicker2").datepicker({ dateFormat: "yy-mm-dd" }).val()
                $("#datepicker2").datepicker();
            });
        </script>
    </head>
    <body>
    <h2>스케쥴 데이터를 입력하세요</h2>
     <form action="insertScheduleAction.do?productpk=<%=request.getParameter("productpk")%>" method="post">
      멘토링 가능날짜를 선택하세요
      <table>
	      <tr> 
		      <td>
            <label for="datepicker" />
                <input type="text" name="startday" id="datepicker1">
		      </td>
		      <td>
            <label for="datepicker" />
                <input type="text" name="endday" id="datepicker2">
		      </td>
	      </tr>
      
      </table>

 
 
		</select> <select name="starttime">
    <%
    for(int i = 10;i<22;i++) { %>
        <option value= <%= i %> > <%= i %></option>
    <% } %>
</select> ~
		</select> <select name="endtime">
    <%for(int i = 11 ;i<22;i++) { %>
        <option value= <%= i %> > <%= i %></option>
    <% } %>
</select>

            <td colspan="2"><input type="submit" value="입력">
       </form>
        
    </body>
</html>