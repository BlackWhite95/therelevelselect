<%@page pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="utf-8">
    <script src="js/jquery-3.2.1.js"></script>
</head>
<body>

<select id="provinceEL">
    <option>----请选择省----</option>
</select>

<select id="cityEL">
    <option>----请选择市----</option>
</select>

<select id="districtEL">
    <option>----请选择区/县----</option>
</select>

<button id="confirmBtn">确定</button>

<input id="adressEL">

<script>
        //1加载所有省
        (function () {
            $.getJSON("/provinces",function (pArray) {
                console.log(pArray)
                $.each(pArray,function (index,item) {
                    $("<option/>").prop("value",item.code).html(item.name).appendTo("#provinceEL");
                })

            })
        })();
        //2给provinceEL加一个chnage事件
        $("#provinceEL").change(function () {
            var pcode=this.value;
            console.log("选择省"+pcode);

            $.getJSON("/citys",{code:pcode},function (citys) {
                console.log(citys);
                var firstChild=$("#cityEL")[0].firstChild;
                $("#cityEL").empty().append(" <option>----请选择市----</option>");

                $.each(citys,function (index,item) {
                    $("<option/>").prop("value",item.code).html(item.name).appendTo("#cityEL");
                })

            })
        });
        //3cityEL加一个chnage事件
        $("#cityEL").change(function () {
            var pcode=this.value;
            console.log("选择省"+pcode);

            $.getJSON("/districts",{code:pcode},function (districts) {
                console.log(districts);
                $("#districtEL").empty().append("  <option>----请选择区/县----</option>");

                $.each(districts,function (index,item) {
                    $("<option/>").prop("value",item.code).html(item.name).appendTo("#districtEL");
                })

            })
        });
        //4confirmBtn加点击事件
        $("#confirmBtn").change(function () {

        });

</script>
</body>
</html>
