
function createOptionsForSelect(arrayOfModels){
    var htmlToBeInserted = "";
    var templ1 = '<option value="' 
    var templ2 = '">'
    var templ3 = '</option> '
    
    arrayOfModels.forEach(element => {
        htmlToBeInserted += templ1 + element + templ2 + element + templ3
    })
    
    return htmlToBeInserted;
}

function addSuitableModels() {
    var e = document.getElementById("marka");
    var choice = e.options[e.selectedIndex].text;
    
    var indexOfModels = marki.indexOf(choice);
        
    var htmlToBeInserted = createOptionsForSelect(models[indexOfModels]);
    
    var modelsField = document.getElementById("model").innerHTML = htmlToBeInserted;
}

function addDefaultModels(){
    var modelsField = document.getElementById("model").innerHTML = createOptionsForSelect(models[0]);
}

function addDefaultBrands(){
    var brandsField = document.getElementById("marka").innerHTML = createOptionsForSelect(marki);
}

function addBrandOrModel(){
    var radiobuttons = document.getElementsByName("rodzaj");
    if (!radiobuttons[0].checked && !radiobuttons[1].checked){
        alert("Należy określić, czy dodajemy nową markę, czy nowy model");
        return;
    }

    var nameOfTheNewInput = document.getElementById("nowa").value;
    if (nameOfTheNewInput == ""){
        alert("Pole Nowa Pozycja nie może być puste!");
        return;
    }

    if (radiobuttons[0].checked) {
        marki.push(nameOfTheNewInput);
        models.push([]);
        addDefaultBrands();

    }
    else if (radiobuttons[1].checked){
        var BrandOfTheModel = document.getElementById("marka").value;
        var indexOfBrand = marki.indexOf(BrandOfTheModel);
        models[indexOfBrand].push(nameOfTheNewInput);
        addSuitableModels();
    }
    
    
}

var marki = ["Volvo", "Audi", "BMW"]
var models = [["xc60", "v40", "s60"], ["a4", "a3", "a6"], ["e46", "x5", "m2"]]


addDefaultBrands();
addDefaultModels();
document.getElementById("marka").addEventListener("change", addSuitableModels);
document.getElementById("submitbtn").addEventListener("click", addBrandOrModel);
