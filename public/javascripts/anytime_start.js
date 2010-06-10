
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
    $('form').submit(function() {
        var defaultConv = new AnyTime.Converter();
        var date = defaultConv.parse($("#object_start").val());
        var date2 = new Date(date);
        alert(date2);
    });
});