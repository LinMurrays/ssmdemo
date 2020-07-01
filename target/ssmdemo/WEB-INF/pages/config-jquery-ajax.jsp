<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<div>
    <h1>配置管理模块</h1>
    <h1><%=new java.util.Date()%>
    </h1>
    <button onclick="doGetObjects()">查询</button>
</div>
<br/>
<div>
    <table border="1" width="100%" cellpadding="1" cellspacing="0">
        <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>value</th>
        </tr>
        </thead>
        <tbody id="tbodyId">
        </tbody>
    </table>
</div>
<script type="text/javascript"
        src="/CGB-SSM-V1.02/js/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        doGetObjects();
    });

    function doGetObjects() {
        //1.params
        var params = "pageCurrent=1&name=o";
        //2.url
        var url = "doFindPageObjects.do";
        //3.ajax request
        $.ajax({//jquery中ajax函数
            url: url,
            data: params,
            success: function (result) {
                //console.log(result);
                doHandleResponseResult(result);
            }
        });
    }

    function doHandleResponseResult(result) {
        //1.获取记录
        var records = result.records;
        //2.获取tbody对象,并清空数据
        var tBody = $("#tbodyId");
        tBody.html("");
        //3.迭代数据并追加到tbody中
        for (var i in records) {
            //3.1创建tr对象
            var tr = $("<tr></tr>");
            //3.2创建tds对象
            var tds = doCreatedTds(records[i]);
            //3.3追加tds到tr对象
            tr.append(tds);
            //3.4追加tr到tbody对象
            tBody.append(tr);
        }
    }

    function doCreatedTds(row) {
        var tds =
            "<td>" + row.id + "</td>" +
            "<td>" + row.name + "</td>" +
            "<td>" + row.value + "</td>";
        return tds;
    }
</script>
</body>
</html>




