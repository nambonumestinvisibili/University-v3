$(function() {
    $("#searchphrase").on('input', findMatchesAndColorStrings)
})

function checkLength(word) {
    if (word.value.length > 2) return true;
    else return false;
}

function findMatchesAndColorStrings() {
    
    var candidates = $('#items').children()
    
    if (!checkLength(this)) {
        uncolourAll(candidates)
        return;
    }

    var pattern = this.value; //comes from input
    var myRe = new RegExp(pattern)

    candidates.each(function () {
        var str = this.innerText //get text from <li> text </li>
        var regexExecutionArray;
        var toBeColoredIndices = []
        var offset = 0
        while ((regexExecutionArray = myRe.exec(str)) !== null) {
            toBeColoredIndices.push(regexExecutionArray.index + offset)
            var previousStr = str;
            str = str.substring(regexExecutionArray.index + pattern.length)
            if (str != previousStr) {
                offset += (previousStr.length - str.length)
            }
        }
        colorMatchingSubstrings(this, toBeColoredIndices, pattern.length)
    }
    )
}

function colorMatchingSubstrings(htmlElement, indicesToBeColored, lengthOfPattern) {
    
    var textToBeChanged = htmlElement.innerText
    for (var i = 0; i < indicesToBeColored.length; i++) {

        var index = indicesToBeColored[i]
        
        var beginning = textToBeChanged.slice(0, index);
        var middle = textToBeChanged.slice(index, index + lengthOfPattern);
        var ending = textToBeChanged.slice(index + lengthOfPattern, textToBeChanged.length)
        
        var middleSpanned = spanConstructor(middle)
        var difference = middleSpanned.length - middle.length

        for (var j = i + 1; j < indicesToBeColored.length; j++) {
            indicesToBeColored[j] += difference
        }

        textToBeChanged = beginning + middleSpanned + ending
    }
    htmlElement.innerHTML = textToBeChanged
}

function spanConstructor(wordToBeSurrounded) {
    return '<span class="highlighted">' + wordToBeSurrounded + '</span>'
}

function uncolourAll(candidates) {
    $(".highlighted").css("background-color", "white");
}