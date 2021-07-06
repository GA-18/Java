var shengfenList='';
function getShengfen(obj) {
    $.ajax({
        type:'GET',
        url:'/getShengfen',
        dataTpe:'json',
        async:false,
        success:function (data) {
            shengfenList=data;
        }

    });
}
$(function () {
    $(document).ready(function () {
        getShengfen($(this));
        alert(shengfenList);
        var split=(shengfenList+"").split(',');
        alert(split);
        alert(split.length);
        var select='<option value="0">--请选择--</option>';
        for (var i=0;i<split.length;i++){
            select=select+'<option value='+(i+1)+'>'+split[i]+'</option>';
        }
        $("#shengfen").html(select);
    });
})



