$(function () {
    $("#menu").tree({
        url: "js/data/menu.json",
        onClick: function (node) {
            if ($("#main_tabs").tabs("exists", node.text)) {
                $("#main_tabs").tabs("select", node.text)
            } else {
                $("#main_tabs").tabs("add", {
                    title: node.text,
                    closable: true,
                    content: '<iframe src="' + node.attributes.url + '" style="width: 100%;height: 99%" frameborder=0><iframe>'
                });
            }
        }
    });
    $("#main_tabs").tabs({
        fit: true,
        closable: true
    })
});
