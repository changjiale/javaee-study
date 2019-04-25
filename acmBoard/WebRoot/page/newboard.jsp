<%@page import="javax.websocket.Session" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>ACM榜单</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="refresh" content="40">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <link rel="stylesheet" type="text/css" href="css/bordcss1.css">
    <script type="text/javascript" src="script/jquery-1.7.2.js"></script>
    <script type="text/javascript">

        $(function () {
            //显示榜单数据


            //设置滑动，用按钮控制
            var viewXH = setInterval(show, 2000);// 注意函数名没有引号和括弧！ */
            var viewHDCookie = $.trim(get_cookie("viewHDCookie"));
            if (viewHDCookie == "0") {
                clearInterval(viewXH);
                viewXH = setInterval(show, 2000);// 注意函数名没有引号和括弧！ */
                $("#intervalFlag").text("取消滑动");
            } else {

                clearInterval(viewXH);
                $("#intervalFlag").text("开启滑动");
            }
            $("#intervalFlag").click(function () {
                clearInterval(viewXH);
                viewHDCookie = $.trim(get_cookie("viewHDCookie"));
                if (viewHDCookie == "1") {
                    viewXH = setInterval(show, 2000);// 注意函数名没有引号和括弧！ */
                    document.cookie = "viewHDCookie=0";
                    $("#intervalFlag").text("取消滑动");
                    // alert("aaa");
                } else {

                    clearInterval(viewXH);
                    document.cookie = "viewHDCookie=1";
                    $("#intervalFlag").text("开启滑动");

                }
            });


            if (document.addEventListener) {//firefox
                document.addEventListener('DOMMouseScroll', function () {
                    clearInterval(viewXH);
                    document.cookie = "viewHDCookie=1";
                    $("#intervalFlag").text("开启滑动");
                }, false);
            }
            //滚动滑轮触发scrollFunc方法  //ie 谷歌
            window.onmousewheel = document.onmousewheel = function () {
                clearInterval(viewXH);
                document.cookie = "viewHDCookie=1";
                $("#intervalFlag").text("开启滑动");
            };

            var mouseFalse = 0;
            document.onmousedown = function (ev) {

                var oEvent = ev || event;
                var disX = oEvent.clientX;
                var ckWidth = $(document).width();
                if ((ckWidth - disX) <= 5) {
                    clearInterval(viewXH);
                    document.cookie = "viewHDCookie=1";
                    $("#intervalFlag").text("开启滑动");
                }

                /*document.onmousemove = function (ev) {
                   mouseFalse = 1;
                }*/
            }
            /* document.onmouseup = function () {
                  document.onmousemove = null;
                  document.onmouseup = null;
                  if(mouseFalse == 1){
                       clearInterval(viewXH);
                       document.cookie="viewHDCookie=1";
                       $("#intervalFlag").text("开启滑动");
                  }
                  document.sc
             }
             */

            //最大数量和最小数量的文本框显示Cookie的数据
            var coMin = $.trim(get_cookie("minStr"));
            var coMax = $.trim(get_cookie("maxStr"));
            if ((coMin != null && coMin != '""') && (coMax != null && coMax != '""')) {
                $(":input[name=minNum]").val(get_cookie("minStr"));
                $(":input[name=maxNum]").val(get_cookie("maxStr"));

            }
            getDatasForCookie();
            //alert(coMin);

            var width = screen.width;

            $("#acmerInfoTable").css("width", width - 20);
            //显示时间
            $("#nowTime").text(getTime());
            setInterval(function () {
                $("#nowTime").text(getTime());
            }, 1000);


            //上下滚动
            // show();
            function show() {
                //  document.cookie="bordFlag=0"
                // alert(get_cookie("bordFlag"));
                var t = $(window).scrollTop();

                scrollTop = $(this).scrollTop();//滚动高度
                var chd = parseInt(get_cookie("viewHDCookie"));
                if (scrollTop >= $(document).height() - $(window).height() && chd == 0) {
                    document.cookie = "bordFlag=0";
                    //document.body.scrollTop = document.documentElement.scrollTop = 0;
                    // clearInterval(viewXH);

                    scrollTo(0, 0);
                    // alert("aaa");

                }
                var ah = parseInt($("#flag").val());

                if (scrollTop >= ah * 60 + 300 && chd == 0) {
                    // alert("BB");scrollTop >= ($(window).height())
                    document.cookie = "bordFlag=0";
                    //  clearInterval(viewXH);
                    scrollTo(0, 0);
                    // $("#flag").attr("value","0");

                }

                if (scrollTop == 0 && chd == 0) {
                    // alert("aa");
                    document.cookie = "bordFlag=1";

                    // viewXH = setInterval(show,2000);// 注意函数名没有引号和括弧！ */
                    //  }, 1000)
                    //$("#flag").attr("value","1");

                }

                var bf = parseInt(get_cookie("bordFlag"));

                // alert(chd);
                if (bf == 1 && chd == 0) {
                    // alert(sf);
                    $('body,html').animate({'scrollTop': t + 80}, 700);

                }
                /*else if( bf == 1){
                    //alert(flag);
                    $('body,html').animate({'scrollTop':t+50},500);
                   
                }*/

            }


            //榜单类型选择事件
            $("#selectBord").click(function () {

                var newMinStr = $.trim($(":input[name=minNum]").val());
                var newMaxStr = $.trim($(":input[name=maxNum]").val());
                document.cookie = "minStr=" + newMinStr;
                document.cookie = "maxStr=" + newMaxStr;

                var type = $("#bordType").val();

                //alert(type);
                $("#acmerInfoTable").empty();
                var minNumStr = get_cookie("minStr");
                var maxNumStr = get_cookie("maxStr");
                if (minNumStr == null || minNumStr == "") {
                    minNumStr = "-1";
                }
                if (maxNumStr == null || maxNumStr == "") {
                    maxNumStr = "200";
                }
                var minNum = parseInt(minNumStr);
                var maxNum = parseInt(maxNumStr);
                //alert(minNum);
                getDatas(type, minNum, maxNum);

                //将新的input 的值给Cookie

                return false;
            });

        });

        //显示时间
        function getTime() {
            var dayNames = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
            var Stamp = new Date();
            var second = Stamp.getSeconds();
            if (second < 10) {
                second = "0" + second;
            }
            var year = Stamp.getYear() + 1900;
            var nowTime = Stamp.getHours() + ":" + Stamp.getMinutes() + ":" + second + " "
                + dayNames[Stamp.getDay()] + "";
            return nowTime;
        };

        //根据Cookie名字获取Cookie的值
        function get_cookie(Name) {
            var search = Name + "="//查询检索的值
            var returnvalue = "";//返回值
            if (document.cookie.length > 0) {
                sd = document.cookie.indexOf(search);
                if (sd != -1) {
                    sd += search.length;
                    end = document.cookie.indexOf(";", sd);
                    if (end == -1)
                        end = document.cookie.length;
                    //unescape() 函数可对通过 escape() 编码的字符串进行解码。
                    returnvalue = unescape(document.cookie.substring(sd, end))
                }
            }
            return returnvalue;
        }

        //根据Cookie 显示
        function getDatasForCookie() {
            var allMinStr1 = $.trim($(":input[name=minNum]").val());
            var allMaxStr1 = $.trim($(":input[name=maxNum]").val());
            var allmin;
            var allmax;
            if (allMinStr1 == "" || allMinStr1 == null)
                allmin = -1;
            else
                allmin = parseInt(allMinStr1);

            if (allMaxStr1 == "" || allMaxStr1 == null)
                allmax = 200;
            else
                allmax = parseInt(allMaxStr1);

            getDatas(2, allmin, allmax);
        }

        //Ajax 获取Action 的信息，并生成榜单
        function getDatas(tpyeBord, teamMinNum, teamMaxNum) {
            // alert(teamMinNum+"-->"+teamMaxNum);
            // alert(tpyeBord);
            var $tr = $("<tr height='60px'></tr>");
            $tr.append("<th style = 'width: 80px;'>排名</th>")
                .append("<th colspan='1'>账号</th>")
                .append("<th style = 'width: 200px;'>队伍名</th>")
                .append("<th style = 'width: 200px;'>班级信息</th>")
                .append("<th style='width: 50px;'>Solved</th>")
                .append("<th>Time</th>");

            //.append("<th style='width: 50px;'>Real Rank</th>")


            //$("acmerInfoTable").append("<tr></tr>")
            var url = "bordInfo.action";
            var args = {"time": new Date()};

            $.ajax({
                url: url,
                data: args,
                async: false,
                type: 'POST',
                success: function (str) {
                    //显示题目个数
                    $.each(str.subjects, function (i, value) {
                        //alert(value);
                        $tr.append("<th>" + value + "</th>");
                    });
                    $tr.appendTo($("#acmerInfoTable"));
                    var gold = str.acmerInfos.length * 0.1;
                    var silver = str.acmerInfos.length * 0.2;
                    var bronze = str.acmerInfos.length * 0.3;
                    var allHDHei = gold + silver + bronze;
                    $("#flag").val(allHDHei.toString());

                    // alert(gold+"-->"+silver+"-->"+bronze);
                    //显示参赛队伍信息
                    $.each(str.acmerInfos, function (i, value1) {
                        //alert(value1.flag);
                        //alert(value1.teamNum);
                        if (((value1.flag == tpyeBord) || tpyeBord == 2) && (value1.teamNum >= teamMinNum && value1.teamNum <= teamMaxNum)) {

                            //alert(value1.flag);
                            var $tr1 = $("<tr height='60px'></tr>");
                            //$tr1.append("<td class = 'rank'>"+value1.rank+"111"+"</th>");

                            if (i <= gold) {
                                $tr1.append("<td style='background-color: yellow; width: 50px;'>" + value1.rank + "</th>");

                            } else if (i > gold && i <= silver + gold) {
                                $tr1.append("<td style='background-color: #DDD;width: 50px;'>" + value1.rank + "</th>");

                            } else if (i > silver + gold && i <= bronze + gold + silver) {
                                $tr1.append("<td style='background-color: #8b4513;width: 50px;'>" + value1.rank + "</th>");

                            } else {
                                $tr1.append("<td style='width: 50px;'>" + value1.rank + "</th>");
                            }

                            $tr1.append("<td>" + value1.name + "</td>")
                                .append("<td>" + value1.nickName + "</td>")
                                .append("<td>" + value1.schoolName + "</td>")
                                .append("<td style='width: 50px;'>" + value1.solved + "</td>")
                                .append("<td>" + value1.time + "</td>");

                            // .append("<td>"+value1.realRank+"</td>")
                            //设置金银铜


                            $.each(value1.probleResult, function (i, valueproble) {
                                $tr1.append("<td class = 'proSt' style='" + valueproble.color + "'>" + valueproble.text + "</td>");

                            });
                            $tr1.append("<td>" + value1.total + "</td>");
                            $tr1.appendTo($("#acmerInfoTable"));

                        }
                    });


                }

            });
        }


    </script>
</head>

<body>
<center>

    <img alt="title" src="image/pdsuacm-icpc.jpg">
    <h1 style="height: 20px">平顶山学院第三届ACM大学生程序设计竞赛</h1><br/>
    <div id="PromptDiv">

        <div id="PromptConLeftDiv">
            <i class="PromptCon"
               style="width: 35px;height: 20px;text-align:center; background-color: yellow;font-size: 13px;">GOLD</i>
            <i class="PromptCon"
               style="width: 50px;height: 20px;text-align:center; background-color: #DDD;font-size: 13px;">SILVER</i>
            <i class="PromptCon"
               style="width: 55px;height: 20px;text-align:center;background-color: #8b4513;font-size: 13px;font-size: 13px;">BRONZE</i>

            <div id="timeCon">
                <i>Last Updated</i><br/>
                <i id="nowTime">2017年1月25日 16:52:32 星期三</i>

            </div>

            <div id="bordSelDiv" style="margin: 8px 4px 0px 20px;">
                <select id="bordType" style="height: 30px">
                    <option value="2" selected="selected">全部榜单</option>
                    <option value="1">专业组</option>
                    <option value="0">非专业组</option>
                </select>
                <input type="text" name="minNum" style="width: 35px"/>
                <font style="text-align: center">--</font>
                <input type="text" name="maxNum" style="width: 35px"/>
                <button id="selectBord" style="height: 30px">选择榜单</button>
                <button id="intervalFlag" style="height: 30px">取消滑动</button>
            </div>

        </div>
        <div id="PromptConRightDiv">
            <i class="PromptConright"
               style="width: 140px;height: 20px;text-align:center; background-color: #FF9999;font-size: 13px;">Attempted
                problem</i>
            <i class="PromptConright"
               style="width: 110px;height: 20px;text-align:center; background-color: #33ff33;font-size: 13px;">Solved
                problem</i>
            <i class="PromptConright"
               style="width: 170px;height: 20px;text-align:center; background-color: #aaaaff;font-size: 13px;">First to
                solve problem</i>
        </div>
    </div>
    <div id="tableDiv">

        <table id="acmerInfoTable" cellpadding="0" cellspacing="0">

            <!-- <caption>河南省第七届ACM大学生程序设计竞赛</caption>
           <tr>
              <td colspan="1">Real ank</td>
               <td width="50px">Real ank</td>
                <td width="50px">Real ank</td>
                 <td width="50px">Real ank</td>
                  <td width="50px">Real ank</td>

           </tr>-->
            <tr><h3>2017 The Third PindDingshan University Programming Contest</h3></tr>

        </table>
        <center></center>
        <input type="hidden" value="1" id="flag"/>
    </div>
    <div>
        <font style="font-size: 20px">Copyright © 2017-04-14 平顶山学院计算机学院(软件学院)算法攻关部 卓靖(jingzhuo)</font></font>
    </div>
</center>
</body>
</html>
