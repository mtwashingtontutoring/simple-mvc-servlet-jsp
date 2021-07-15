<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>${formName}</h1>
    <form method="POST">
        <div>
            <label for="param1">Param 1</label>
            <input type="text" id="param1" name="param1" value="${model.param1}" placeholder="enter 0-12">
            &nbsp;<span style="color: red">${param1Errors}</span>
        </div>
        <div>
            <label for="param2">Param 2</label>
            <input type="text" id="param2" name="param2" value="${model.param2}" placeholder="enter a,b or c">
            &nbsp;<span style="color: red">${param2Errors}</span>
        </div>
        <div>
            <label for="param3">Param 3</label>
            <input type="date" id="param3" name="param3" value="${model.param3}" placeholder="enter date">
            &nbsp;<span style="color: red">${param3Errors}</span>
        </div>
        <div>
            <label for="param4">Param 4</label>
            <input type="text" id="param4" name="param4" value="${model.param4}" placeholder="6 characters min">
            &nbsp;<span style="color: red">${param4Errors}</span>
        </div>
        <input type="submit">
    </form>
</body>
</html>
