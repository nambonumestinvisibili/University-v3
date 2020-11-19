$(function(){
    var galleryDivs = $("#gallery").children()
    giveThePhotosClickHandlers(galleryDivs);
    giveThePhotosIds(galleryDivs);
    createSelectUnselectButtons(galleryDivs);
    createLogButton(galleryDivs);        
})

function giveThePhotosClickHandlers(galleryDivs){
    galleryDivs.each(function() {
        $(this).on("click", function () {
            var current = $(this)
            if (current.data("marked") == undefined || current.data("marked") == false){
                return selectAPhoto(current)
            }
            else return unSelectAPhoto(current);
        })
    });
}

function giveThePhotosIds(galleryDivs){
    var i = 1;
    galleryDivs.each(function (){
        $(this).data("photoID", i);
        i++;
    })
}

function selectAPhoto(photo){
    photo.data("marked", true);
    photo.css("border-color", "blue");
}

function unSelectAPhoto(photo){
    photo.data("marked", false);
    photo.css("border-color", "black");
}

function selectAllPhotos(arrayOfPhotosElement){
    arrayOfPhotosElement.each(function (){
        selectAPhoto($(this));
    })
}

function unSelectAllPhotos(arrayOfPhotosElement){
    arrayOfPhotosElement.each(function () {
        unSelectAPhoto($(this));
    })
}

function createSelectUnselectButtons(galleryDivs){
    var gallery = $("#gallery");
    gallery.append("<button id='select'>Select All Photos</button>");
    $("#select").on("click", function(){
        selectAllPhotos(galleryDivs)
    })

    gallery.append("<button id='unselect'>Unselect All Photos</button>");
    $("#unselect").on("click", function(){
        unSelectAllPhotos(galleryDivs)
    })
}

function createLogButton(galleryDivs){
    var gallery = $("#gallery");
    gallery.append("<button id='logButton'>Put photos ids in log field</button>");
    
    $("#logButton").on('click', function(){
        var result = "Selected photos IDs: [";
        galleryDivs.each(function(){
            current = $(this)
            if(current.data("marked")){
                result += current.data("photoID") + ", "
            }
        })
        result += "]"

        $("#logger").text(result);
    })
}