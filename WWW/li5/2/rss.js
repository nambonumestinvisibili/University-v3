$(function () {
    const proxyurl = "https://cors-anywhere.herokuapp.com/";
    const url = proxyurl + "https://tvn24.pl/najnowsze.xml";

    //jQuery.get() is equivalent to:
    $.ajax({
        url: url,
        dataType: 'xml',    //this way we are using $.parseXML
        success: doSomething
    })    

    function doSomething(data){
        var itemsList = $(data).find('item').slice(0,5)
        var toBeShown = "<ul>"

        itemsList.each(function (){
            toBeShown += "<li>"
            var title = '<span class="title">' + $(this).find('title').text() + "</span> <br>"
            var link = '<a href="' + $(this).find('link').text() + '"> Link </a> <br>'
            var description = $(this).find('description').text() + "<br>"

            toBeShown += title + '<br>' + link + description + "</li>"
        })

        toBeShown += "</ul>"
        $("body").append(toBeShown)
    }
})

































// $(function () {
//     const proxyurl = "https://cors-anywhere.herokuapp.com/";
//     const url = "https://tvn24.pl/najnowsze.xml"
//     var xml;
//     var got = fetch(proxyurl + url) // https://cors-anywhere.herokuapp.com/https://example.com
//         // .then(response => response.text())
//         // .then(contents => console.log(contents))
//         .then(response => {
//             response = response.text()
//             var xmldoc = $.parseXML(response)
//             var xml = $(xmldoc)
//             console.log(xml)
//             $("body").append(xml)
//             // console.log($.parseXML(response.text()))
//         })
// })
