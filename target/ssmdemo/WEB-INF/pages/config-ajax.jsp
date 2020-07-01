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
<script type="text/javascript">
    window.onload = function () {
        //初始化tbodyId
        var tBody = document.getElementById("tbodyId");
        var tr = document.createElement("tr");
        var td = document.createElement("td");
        td.setAttribute("colspan", 3);
        td.innerText = "数据正在加载中..."
        tr.appendChild(td);
        tBody.appendChild(tr);
        //异步加载数据
        doGetObjects();

        console.log("helloworld");
    }

    function doGetObjects() {
        //1.构建ajax请求对象
        var xhr = new XMLHttpRequest();
        console.log(xhr);
        //2.设置请求对象的状态监听
        xhr.onreadystatechange = function () {
            //此函数为系统回调函数，当请求响应状态发生变化时会回调此函数
            doHandleResponseResult(xhr);
        }

        //3.建立连接(client-server)
        var url = "doFindPageObjects.do?pageCurrent=1&name=o"
        xhr.open("GET", url, true);//true表示异步

        //4.发送ajax请求
        xhr.send(null);//POST请求会将null替换具体参数，GET请求不需要写
    }

    function doHandleResponseResult(xhr) {
        //输出服务端返回的数据
        //responseText为服务端返回的文本
        if (xhr.readyState == 4 && xhr.status == 200) {
            //console.log(xhr.responseText);
            //1.将json格式的字符串,解析为json格式的js对象
            var result = JSON.parse(xhr.responseText);
            console.log(result);
            //2.获取tbody对象清空内容
            var tBody = document.getElementById("tbodyId");
            //tBody.innerHTML="";
            //3.迭代数据
            var records = result.records;
            for (var i = 0; i < records.length; i++) {
                //3.1构建tr对象
                var tr = document.createElement("tr");
                //3.2构建tds对象
                var td1 = document.createElement("td");
                td1.innertext = records[i].id;
                var td2 = document.createElement("td");
                td2.innertext = records[i].name;
                var td3 = document.createElement("td");
                td3.innertext = records[i].value;

                //3.3将tds追加tr中
                tr.appendChild(td1);
                tr.appendChild(td2);
                tr.appendChild(td3);

                //3.4将tr追加到tbody中
                tBody.appendChild(tr);

            }
        }
    }
</script>
</body>
</html>



















