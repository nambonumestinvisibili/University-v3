var adjs = $("#adjs")       .text().split("\n").map(function (x) {return x.replace("                 ", "")})
var nouns = $("#nouns")     .text().split("\n").map(function (x) {return x.replace("                 ", "")})
var verbs = $("#verbs")     .text().split("\n").map(function (x) {return x.replace("                 ", "")})
var adverbs = $("#adverbs") .text().split("\n").map(function (x) {return x.replace("                 ", "")})
var sentenceParts = [adverbs, verbs, adjs, nouns]

sentenceParts.forEach(function(x) {
    x.shift()
    x.pop()
})

function generateRandomWord(array) {
    var mini = 0
    var maks = array.length - 1
    return array[Math.floor(Math.random() * (maks - mini + 1)) + mini]
}

$("#generate").click(function () {
    var result = ""
    sentenceParts.forEach(function(x){
        result += generateRandomWord(x) + " "
    })
    $("#generated").text(result)
})