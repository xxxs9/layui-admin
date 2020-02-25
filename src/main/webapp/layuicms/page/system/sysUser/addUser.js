layui.config({
    base: $config.resUrl+'layuicms/common/js/'//定义基目录
}).extend({
    ajaxExtention: 'ajaxExtention',//加载自定义扩展，每个业务js都需要加载这个ajax扩展
    $tool: 'tool',
    $api:'api'
}).use(['form', 'layer', 'tree','$api', 'jquery', 'ajaxExtention', '$tool'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,
        $ = layui.jquery,
        $tool = layui.$tool,
        $api = layui.$api;

    var orgId;
    var orgName;
    var roleIdList = new Array();//所有的角色id列表

    /**
     * 页面初始化
     * */
    /* function init() {
         //初始化机构树
         initOrgTree();
         //加载角色列表
         loadRoleList();
     }

     init();*/

    /**
     * 初始化组织机构树
     * */
    /* function initOrgTree() {
         //获取所有组织机构树

         $api.GetAllOrg(null,function (res) {
             renderTree('#org-tree', res.data);
         });

     }*/
//按钮组id
    var radioGroupId = 1;

    /*新增子标准*/
    function addLowStandard(div){
        var Demo =div.parentNode.parentNode;
        var mtlvaluelow=Demo.getElementsByClassName("mtlvaluelow")[0];
        var TitleLowStandard ='<label class="layui-form-label">子标准</label>\n' +
            '                    <div class="mtlvalue layui-input-block">\n' +
            '                    <input type="text" class="layui-input" name="mtlvalue"  placeholder="请输入子标准">\n' +
            '                    </div>';
        mtlvaluelow.innerHTML+=TitleLowStandard;
    }
    /*删除子标准*/
    function deleteLowStandard(div) {
        var Demo =div.parentNode.parentNode;
        var mtlvaluelow=Demo.getElementsByClassName("mtlvaluelow")[0];
        var mtlvaluelowGroup = mtlvaluelow.getElementsByClassName("mtlvalue");
        var labelGroup = mtlvaluelow.getElementsByClassName("layui-form-label");
        if (mtlvaluelowGroup.length<=2){
            alert("一个标准至少有两个子标准");
        }else {
            mtlvaluelowGroup[mtlvaluelowGroup.length-1].remove();
            labelGroup[labelGroup.length-1].remove();
        }

    }

    /*
    * 新增标准
    * */

    function addStandard(div){
        /*var addTitleStandard=''*/
        //获取他的上一级元素
        radioGroupId++;
        var divDemo = div.parentNode.parentNode.parentNode;

        var TitleStandard = '<div class="mtstitle layui-form-item">\n' +
            '                <label class="layui-form-label">标准</label>\n' +
            '                <div class="layui-input-block">\n' +
            '                <input type="text" class="layui-input" name="mtstitle"  placeholder="请输入标准">\n' +
            '                </div>\n' +
            '                <!--单选多选框 单选值为0 多选为1-->\n' +
            '                <div class="layui-input-block">\n' +
            '                    <input type="radio" name="'+radioGroupId+'" value="0" title="单选" class="mtstype">\n' +
            '                    <input type="radio" name="'+radioGroupId+'" value="1" title="多选" class="mtstype">\n' +
            '                </div>\n' +
            '                <div class="layui-input-block">\n' +
            '                <button class="layui-btn"   type="button" onclick="addStandard(this)">新增标准</button>\n' +
            '                </div>\n' +
            '                <div class="layui-input-block">\n' +
            '                   <div class="mtlvaluelow" id="mtlvaluelow">\n' +
            '                    <label class="layui-form-label">子标准</label>\n' +
            '                    <div class="mtlvalue layui-input-block">\n' +
            '                    <input type="text" class="layui-input" name="mtlvalue"  placeholder="请输入子标准">\n' +
            '                    </div>\n' +
            '                    <label class="layui-form-label">子标准</label>\n' +
            '                    <div class="mtlvalue layui-input-block">\n' +
            '                    <input type="text" class="layui-input" name="mtlvalue"  placeholder="请输入子标准">\n' +
            '                    </div>\n' +
            '                       <!--新增子标准在这-->\n' +
            '                   </div>\n' +
            '                    <!--新增子标准-->\n' +
            '                    <div class="layui-input-inline">\n' +
            '                        <!--<i class="layui-icon layui-icon-add-1" style="font-size: 30px; color: #1E9FFF;"></i>-->\n' +
            '                        <button class="layui-btn"   type="button" onclick="addLowStandard(this)">新增子标准</button>\n' +
            '\n' +
            '                    </div>\n' +
            '                    <div class="layui-input-inline">\n' +
            '                        <!--<i class="layui-icon layui-icon-add-1" style="font-size: 30px; color: #1E9FFF;"></i>-->\n' +
            '                        <button class="layui-btn"   type="button" onclick="deleteLowStandard(this)">删除子标准</button>\n' +
            '\n' +
            '                    </div>\n' +
            '\n' +
            '                </div>\n' +
            '\n' +
            '            </div>';

        divDemo.innerHTML+=TitleStandard;
        form.render();
    }

    /*
    * 新增子标题
    * */
    function  addTitle(){
        radioGroupId++;
        var addTitle = '  <div class="mttitle layui-form-item">\n' +
            '            <label class="layui-form-label">子标题</label>\n' +
            '            <div class="layui-input-block">\n' +
            '            <input type="text" class="layui-input" name="mttitle"  placeholder="请输入子标题">\n' +
            '            </div>\n' +
            '            <!--标准1-->\n' +
            '            <div class="mtstitle layui-form-item">\n' +
            '                <label class="layui-form-label">标准</label>\n' +
            '                <div class="layui-input-block">\n' +
            '                <input type="text" class="layui-input" name="mtstitle"  placeholder="请输入标准">\n' +
            '                </div>\n' +
            '                <!--单选多选框 单选值为0 多选为1-->\n' +
            '                <div class="layui-input-block">\n' +
            '                    <input type="radio" name="1" value="0" title="单选" class="mtstype">\n' +
            '                    <input type="radio" name="1" value="1" title="多选" class="mtstype">\n' +
            '                </div>\n' +
            '                <div class="layui-input-block">\n' +
            '                <button class="layui-btn"   type="button" onclick="addStandard(this)">新增标准</button>\n' +
            '                </div>\n' +
            '                <div class="layui-input-block">\n' +
            '                   <div class="mtlvaluelow" id="mtlvaluelow">\n' +
            '                    <label class="layui-form-label">子标准</label>\n' +
            '                    <div class="mtlvalue layui-input-block">\n' +
            '                    <input type="text" class="layui-input" name="mtlvalue"  placeholder="请输入子标准">\n' +
            '                    </div>\n' +
            '                    <label class="layui-form-label">子标准</label>\n' +
            '                    <div class="mtlvalue layui-input-block">\n' +
            '                    <input type="text" class="layui-input" name="mtlvalue"  placeholder="请输入子标准">\n' +
            '                    </div>\n' +
            '                       <!--新增子标准在这-->\n' +
            '                   </div>\n' +
            '                    <!--新增子标准-->\n' +
            '                    <div class="layui-input-inline">\n' +
            '                        <!--<i class="layui-icon layui-icon-add-1" style="font-size: 30px; color: #1E9FFF;"></i>-->\n' +
            '                        <button class="layui-btn"   type="button" onclick="addLowStandard(this)">新增子标准</button>\n' +
            '\n' +
            '                    </div>\n' +
            '                    <div class="layui-input-inline">\n' +
            '                        <!--<i class="layui-icon layui-icon-add-1" style="font-size: 30px; color: #1E9FFF;"></i>-->\n' +
            '                        <button class="layui-btn"   type="button" onclick="deleteLowStandard(this)">删除子标准</button>\n' +
            '\n' +
            '                    </div>\n' +
            '\n' +
            '                </div>\n' +
            '\n' +
            '            </div>\n' +
            '          <!--新增标准会在这位置-->\n' +
            '\n' +
            '        </div>';
        var c=document.getElementById('BIG');

        c.innerHTML+=addTitle;
    }

    /*添加为模板*/

    /*模板弹窗事件*/
    function openFun(){
        layer.open({
            id:1,
            type: 1,
            title:'添加为模板',
            skin:'layui-layer-rim',
            area:['450px', 'auto'],

            content: ' <label class="layui-form-label">请输入模板标题</label>\n' +
                ' <div class="mtlvalue layui-input-block">\n' +
                ' <input type="text" class="layui-input" name="templmentname"  placeholder="请输入模板标题">\n' +
                ' </div>'

            ,
            btn:['保存','取消'],
            btn1: function (index,layero) {
                if (layero.find("input[name='templmentname']").val().length==0){
                    alert("模板标题不可为空");
                }
                /*alert(layero.find("input[name='templmentname']").val());*/
            },
            btn2:function (index,layero) {
                layer.close(index);
            }

        });
    };

    $('#addMinzhutemplment').click(function () {

        openFun();



    })

    form.on('checkbox(write)', function(data){
        alert("123")
        console.log(data.elem); //得到checkbox原始DOM对象
        console.log(data.elem.checked); //是否被选中，true或者false
        console.log(data.value); //复选框value值，也可以通过data.elem.value得到
        console.log(data.othis); //得到美化后的DOM对象
    });

    /**
     * 表单提交
     * */
    form.on("submit(addMinzhu)", function (data) {
        /* var ti = data.field.mtl_value;*/
        //获取大标题 说明 投票人数
        var mtitle = data.field.mtitle;
        var mexplain = data.field.mexplain;
        var mnumber = data.field.mnumber;
        var Minzhu ={
            mtitle:mtitle,
            mexplain:mexplain,
            mnumber:mnumber,
            templment:0,
            level:0,
            out:1,
            isdelete:0,

            minzhuTitles:[]
        }



        var mttitleDemo = $(".mttitle");
        //循环子标题
        for (var i=0;i<mttitleDemo.length;i++){
            var mttitle =  mttitleDemo.eq(i).find("input[name='mttitle']").val();
            var MinzhuTitle ={
                mttitle:mttitle,
                minzhuTitleStandardList:[]
            };
            //循环标准
            var mtstitleDemo = mttitleDemo.eq(i).find(".mtstitle");
            for (var j=0;j<mtstitleDemo.length;j++){
                var mtstitle = mtstitleDemo.eq(j).find("input[name='mtstitle']").val();
                var mtstype =mtstitleDemo.eq(j).find("input[class='mtstype']").val();
                //循环子标准
                var mtlvalueDemo = mtstitleDemo.eq(j).find(".mtlvalue");
                var MinzhuTitleStandard ={
                    mtstitle:mtstitle,
                    mtstype:mtstype,
                    minzhuTitleLowstandardList:[]
                };

                for (var z=0;z<mtlvalueDemo.length;z++){
                    var mtlvalue = mtlvalueDemo.eq(z).find("input[name='mtlvalue']").val();
                    var MinzhuTitleLowstandard={
                        mtlvalue:mtlvalue
                    };
                    MinzhuTitleStandard.minzhuTitleLowstandardList.push(MinzhuTitleLowstandard);
                }
                MinzhuTitle.minzhuTitleStandardList.push(MinzhuTitleStandard);
            }
            Minzhu.minzhuTitles.push(MinzhuTitle);
        }


        var req =Minzhu;


        /* var zbt = $("[name='mttitle']");
         var bz = $("[name='mtstitle']");
         var zbz= $("[name='mtlvalue']");


          zbt.each(function (index,inzibiaoti) {

              zibiaoti.push($(inzibiaoti).val());

               alert(zibiaoti);

          });

          bz.each(function (index,inbiaozhun) {
              biaozhun.push($(inbiaozhun).val());
          });

          zbz.each(function (index,inzibiaozhun) {
              zibiaozhun.push($(inzibiaozhun).val());
          });

       var Minzhu ={
             mtitle:mtitle,
             mexplain:mexplain,
             mnumber:mnumber,
             minzhuTitles:
         };
  */






        /*var req = {
            mtitle: mtitle,
            mexplain: mexplain,
            mnumber: mnumber,
            minzhuTitles:zibiaoti.toString(),

        };*/

        $api.AddMinzhu(JSON.stringify(req),{contentType:"application/json;charset=UTF-8"},function (data) {

            //top.layer.close(index);(关闭遮罩已经放在了ajaxExtention里面了)
            layer.msg("民主测评添加成功！", {time: 1000}, function () {
                layer.closeAll("iframe");
                //刷新父页面
                parent.location.reload();
            });
        });

        /*alert(zibiaoti);*/
        /*alert(zibiaozhun);
        alert(biaozhun);*/





        /*console.log(ti);*/
        /*var loginName = data.field.loginName;
        var realName = data.field.realName;
        var mobile = data.field.mobile;
        var idList = new Array();

        if($tool.isBlank(orgId)||$tool.isBlank(orgName)){
            layer.msg("请选择所属组织机构");
            return false;
        }

        //获取选中的角色列表
        for (var i = 0; i < roleIdList.length; i++) {
            if (data.field[roleIdList[i]] === 'on') {
                idList.push(roleIdList[i]);
            }
        }

        //请求
        var req = {
            loginName: loginName,
            realName: realName,
            mobile: mobile,
            orgId: orgId,
            orgName: orgName,
            roleIdList: idList
        };

        $api.AddUser(JSON.stringify(req),{contentType:"application/json;charset=UTF-8"},function (data) {
            //top.layer.close(index);(关闭遮罩已经放在了ajaxExtention里面了)
            layer.msg("用户添加成功！", {time: 1000}, function () {
                layer.closeAll("iframe");
                //刷新父页面
                parent.location.reload();
            });
        });

        return false;*/
    })

});

/*
form.on("submit(addMinzhu)", function (data) {
    /!* var ti = data.field.mtl_value;*!/
    //获取大标题 说明 投票人数
    var mtitle = data.field.mtitle;
    var mexplain = data.field.mexplain;
    var mnumber = data.field.mnumber;
    var Minzhu ={
        mtitle:mtitle,
        mexplain:mexplain,
        mnumber:mnumber,
        templment:0,
        level:0,
        out:1,
        isdelete:0,

        minzhuTitles:[]
    }


    var mttitleDemo = $(".mttitle");
    //循环子标题
    for (var i=0;i<mttitleDemo.length;i++){
        var mttitle =  mttitleDemo.eq(i).find("input[name='mttitle']").val();
        var MinzhuTitle ={
            mttitle:mttitle,
            minzhuTitleStandardList:[]
        };
        //循环标准
        var mtstitleDemo = mttitleDemo.eq(i).find(".mtstitle");
        for (var j=0;j<mtstitleDemo.length;j++){
            var mtstitle = mtstitleDemo.eq(j).find("input[name='mtstitle']").val();
            var mtstype =mtstitleDemo.eq(j).find("input[class='mtstype']").val();
            //循环子标准
            var mtlvalueDemo = mtstitleDemo.eq(j).find(".mtlvalue");
            var MinzhuTitleStandard ={
                mtstitle:mtstitle,
                mtstype:mtstype,
                minzhuTitleLowstandardList:[]
            };

            for (var z=0;z<mtlvalueDemo.length;z++){
                var mtlvalue = mtlvalueDemo.eq(z).find("input[name='mtlvalue']").val();
                var MinzhuTitleLowstandard={
                    mtlvalue:mtlvalue
                };
                MinzhuTitleStandard.minzhuTitleLowstandardList.push(MinzhuTitleLowstandard);
            }
            MinzhuTitle.minzhuTitleStandardList.push(MinzhuTitleStandard);
        }
        Minzhu.minzhuTitles.push(MinzhuTitle);
    }
});*/
