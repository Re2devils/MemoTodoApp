

$("#menu-btn").click(function (e) {
    $("#menu").css({"left":"0", "width":"100%"});
});

$("#back-btn").click(()=>{
    $("#menu").css({"left":"-120%", "width":"0"});
})