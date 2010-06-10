$(document).ready(function(){
    var dd = new Date();
    dd.setTime(parseInt($("#object_end").val()));
    var dateconv = new AnyTime.Converter({
        utcFormatOffsetImposed: 0,
        format:"%Y-%m-%d %H:%i:%s %E %#"
    });

    $("#object_end").val(dateconv.format(dd));
    $("#object_end").AnyTime_picker(
    {
        format: "%Y-%m-%d %H:%i:%s %E %#",
        formatUtcOffset: "%: (%@)",
        hideInput: true,
        placement: "inline"
    } );
    $("input[type='submit']").click(function() {

        var defaultConv = new AnyTime.Converter();
        var date = defaultConv.parse($("#object_end").val());
        $("#object_end").val(date.getTime());
    });
});