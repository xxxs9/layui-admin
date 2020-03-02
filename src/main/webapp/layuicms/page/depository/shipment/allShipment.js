layui.config({
    base: $config.resUrl+'layuicms/common/js/'//定义基目录
}).extend({
    ajaxExtention: 'ajaxExtention',//加载自定义扩展，每个业务js都需要加载这个ajax扩展
    $tool: 'tool',
    $api:'api'
}).use(['laydate','form', 'layer','$api', 'jquery', 'table', 'laypage','laytpl', 'ajaxExtention', '$tool'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        laypage = layui.laypage,
        $tool = layui.$tool,
        table = layui.table,
        $api = layui.$api,
        laydate = layui.laydate;

    var tableIns;//表格实例

    function init() {
        initDate();//初始化日期选择框
    }

    init();
    /**
     * 初始化日期选择
     * */
    function initDate() {
        laydate.render({
            elem: '#applyTime',
            type: 'date',
            format: 'yyyy-MM-dd HH:mm:ss'
        });
    }
    /**
     * 定义表格
     * */
    function defineTable() {
        tableIns = table.render({
            elem: '#shipment-data'
            , height: 415
            , url: $tool.getContext() + 'shipment/list' //数据接口
            , method: 'post'
            , page:true //开启分页
            , cols: [[ //表头
                {type:'numbers',title:'序号',fixed: 'left'},
                {field: 'shipmentTypeName', title: '出库类型', width: '10%'},
                {field: 'shipmentModeTypeName', title: '出库模式', width: '10%'},
                {field: 'relationId', title: '订单编号', width: '20%'},
                {field: 'productName', title: '货品名称', width: '10%'},
                {field: 'number', title: '数量', width: '10%'},
                {field: 'shipmentDate', title: '出库日期', width: '10%'},
                {field: 'mark', title: '备注', width: '20%'}
            ]]
            , done: function (res, curr) {//请求完毕后的回调
                //如果是异步请求数据方式，res即为你接口返回的信息.curr：当前页码
            }
        });
    }
    defineTable();


    //查询
    form.on("submit(queryShipment)", function (data) {
        var orderNumber = data.field.orderNumber;
        var applyTime = data.field.applyTime;
        //表格重新加载
        tableIns.reload({
            where:{
                orderNumber:orderNumber,
                date:applyTime
            }
        });

        return false;
    });
});