
$(document).ready(function(){
    $("#object_start").AnyTime_picker(
    {
        format: "%Y-%m-%d %H:%i:%s %E %#",
        formatUtcOffset: "%: (%@)",
        hideInput: true,
        placement: "inline"
    } );
});

$(document).ready(function(){
    $("input[type='submit']").click(function() {
        var defaultConv = new AnyTime.Converter();
        var date = defaultConv.parse($("#object_start").val());
        $("#object_start").val(date.getTime());
    });
});