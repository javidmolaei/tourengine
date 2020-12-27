document.onreadystatechange = function () {
    var state = document.readyState;
    if (state == 'complete') {
        document.getElementById('interactive');
        document.getElementById('load').style.visibility="hidden";
    }
}
$(document).ready(function(){
    'use strict';

    //Uncomment if you wish to auto redirect without click on the logo on the page loading
    // if($('.loading-logo.customer').length>0){
    //     setTimeout(function(){
    //         window.location.href="sign-up.html";
    //     }, 3000);
    // }
    //
    // if($('.loading-logo.driver').length>0){
    //     setTimeout(function(){
    //         window.location.href="sign-in.html";
    //     }, 3000);
    // }

    var input = document.querySelector("#phone-input");
    if(input) {
        window.intlTelInput(input, {
            autoPlaceholder: "aggressive",
            utilsScript: "https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/8.4.6/js/utils.js"
        });
    }


    $('.fas.fa-star').on('mouseover', function(){
        var index = $(this).index();
        $(this).parent().find('.fas.fa-star').addClass('font-weight-light');
        for(var i=0;i<=index;i++){
            var star = $(this).parent().find('.fas.fa-star')[i];
            $(star).removeClass('font-weight-light');
        }
    });

    var starAmount = 0;
    $('.fas.fa-star').on('click', function(){
        var index = $(this).index();
        starAmount = index+1;
    });

    $('.rating').on('mouseout', function(){
        if(starAmount>0){
            for(var i=0;i<starAmount;i++){
                var star = $(this).find('.fas.fa-star')[i];
                $(star).removeClass('font-weight-light');
            }
        }
        else{
            $('.fas.fa-star').addClass('font-weight-light');
        }
    });

    $('.remove-email-paypal').on('click',function(e){
        e.preventDefault();
        $('input[type=radio]').prop('checked',false);
    });

    $('.request-btn .decline').on('click', function(){
        $(this).closest('.row').find('.request-notification-container .num').html($(this).closest('.all-history-items').find('.request-item-container').length-1);
        $(this).closest('.request-item-container').remove();
    });

    $('.map-input .remove').on('click', function(){
        $(this).closest('.map-input').find('input').val("");
        hideMarkers();
        $('.not-map>div').addClass('hidden');
    });

    $('.map-input input').on('focus', function(){
        $('.title').text("Set Address");
        $('.gm-style > div:first-child').hide("slow");
        $('.back-to-map').removeClass('hidden');
    });

    $('.map-input input').on('blur', fromSetRouteToAddRoute);

    $('.back-to-map').on('click',fromSetRouteToAddRoute);

    $('.car-option').on('click',function(){
        $('.car-option').removeClass('active');
        $(this).addClass('active');
        $('.about-section > div').addClass('hidden');
        $('.about-section .' + $(this).data('about-target-id')).removeClass('hidden');
    });

    $('.request-ride-btn').on('click', function(){
        $(this).addClass('hidden');
        $('.ride-options-bottom').removeClass('hidden');
    });

    $('.send-wishes-container').on('click', function(){
        var wishContainer = $('.ride-options-bottom').height();
        $('.ride-options-bottom').addClass('hidden');
        $('.wish-container').removeClass('hidden').height(wishContainer);
    });

    $('.close-wish').add('.send-wish-btn').on('click', function(){
        $('.ride-options-bottom').removeClass('hidden');
        $('.wish-container').addClass('hidden');
        $('.wish-content-intro-container').removeClass('hidden');
        $('.enter-wish').addClass('hidden');
        $('.wishes-main-text').removeClass('hidden');
        $('.enter-wish textarea').val('');
        $('.send-wish-btn').addClass('hidden');
    });

    $('.wish-content-intro-container').on('click', function(){
        $('.enter-wish').removeClass('hidden');
        $('.wishes-main-text').addClass('hidden');
        $(this).addClass('hidden');
        $('.send-wish-btn').removeClass('hidden');
    });

    $('.confirm-ride-btn').on('click',function(){
        $('.tap-on-car').removeClass('hidden');
        $('.ride-options-bottom').addClass('hidden');
        var icons = {
            0: new google.maps.MarkerImage(
                // URL
                '../images/taxi-icon-180.png',
                // (width,height)
                new google.maps.Size( 23, 23 ),
                // The origin point (x,y)
                new google.maps.Point( 0, 0 ),
                // The anchor point (x,y)
                new google.maps.Point( 0, 6 )
            ),
            1: new google.maps.MarkerImage(
                // URL
                '../images/taxi-icon.png',
                // (width,height)
                new google.maps.Size( 23, 23 ),
                // The origin point (x,y)
                new google.maps.Point( 0, 0 ),
                // The anchor point (x,y)
                new google.maps.Point( 0, 6 )
            ),
            2: new google.maps.MarkerImage(
                // URL
                '../images/taxi-icon-180.png',
                // (width,height)
                new google.maps.Size( 23, 23 ),
                // The origin point (x,y)
                new google.maps.Point( 0, 0 ),
                // The anchor point (x,y)
                new google.maps.Point( 0, 6 )
            ),
            3: new google.maps.MarkerImage(
                // URL
                '../images/taxi-icon-180.png',
                // (width,height)
                new google.maps.Size( 23, 23 ),
                // The origin point (x,y)
                new google.maps.Point( 0, 0 ),
                // The anchor point (x,y)
                new google.maps.Point( 0, 6 )
            ),
            4: new google.maps.MarkerImage(
                // URL
                '../images/taxi-icon-270.png',
                // (width,height)
                new google.maps.Size( 23, 23 ),
                // The origin point (x,y)
                new google.maps.Point( 0, 0 ),
                // The anchor point (x,y)
                new google.maps.Point( 9, 0 )
            ),
            5: new google.maps.MarkerImage(
                // URL
                '../images/taxi-icon-180.png',
                // (width,height)
                new google.maps.Size( 23, 23 ),
                // The origin point (x,y)
                new google.maps.Point( 0, 0 ),
                // The anchor point (x,y)
                new google.maps.Point( 0, 6 )
            ),
            6: new google.maps.MarkerImage(
                // URL
                '../images/taxi-icon-90.png',
                // (width,height)
                new google.maps.Size( 23, 23 ),
                // The origin point (x,y)
                new google.maps.Point( 0, 0 ),
                // The anchor point (x,y)
                new google.maps.Point( 9, 0 )
            )
        };
        var markerList = [{lat: 42.262651,lng: -71.828033},
            {lat:42.273543,lng: -71.817843},
            {lat: 42.267627, lng: -71.810578},
            {lat: 42.271398,lng: -71.802753},
            {lat: 42.269234, lng:-71.810193},
            {lat: 42.263405, lng:-71.816964},
            {lat:42.272021, lng:-71.812448}];
        $('#searchingModal').modal('show');
        setTimeout(function(){
            for(var i=0;i<markerList.length;i++){
                makeMarker(markerList[i],icons[i], 'Potential Driver', true);
            }
 
            $('#searchingModal').modal('hide');
        }, 3000);

    });

    $('.requested-car-info .request-btn').on('click', function(){
        $('.ride-status').removeClass('hidden');
        $(this).addClass('hidden');
        $('.pending-spinner').removeClass('hidden');
        setTimeout(function(){
            $('.tapped-car-info').removeClass('disabled');
            $('.pending-icon').addClass('approved-icon').removeClass('pending-icon');
            $('.pending-request').addClass('hidden');
            $('.just-approved').removeClass('hidden');
            setTimeout(function(){
                $('.just-approved').addClass('hidden');
                $('.on-the-way').removeClass('hidden');
                $('.miles-till-arrival').removeClass('hidden');
            }, 3000);
        }, 3000);
    });

    $(document).on('click', '.tapped-car-info .slide-up', function(){
        $(this).removeClass('slide-up').addClass('slide-down');
        $(this).find('img').attr('src','../icons/down-arrow.svg');
        $('.requested-car-info').css('border-bottom','1px solid #F1F3F8');
        $('.tapped-car-info').addClass('more').animate({
            top: '200px'
        }, 500);
        $('.tapped-car-more-info').removeClass('hidden');
        $('.tapped-car-info-container').addClass('more');
    });

    $(document).on('click', '.tapped-car-info .slide-down', function(){
        $(this).removeClass('slide-down').addClass('slide-up');
        $(this).find('img').attr('src','../icons/up-arrow.svg');
        var wh = parseInt($(window).height());
        var v = wh-292;
        $('.tapped-car-info').removeClass('more').animate({
            top: v+'px'
        }, 500, function () {
            $('.requested-car-info').css('border','none');
        });
        $('.tapped-car-info-container').removeClass('more');
    });

    $('.send-chat').on('click',function(){
        sendChat();
    });

    $('.message-input').on('keyup', function(e){
        if(e.which == 13) {
            sendChat();
        }
    });

    $(document).on('click','.ride-status .approved-icon.call', function(){
        $(this).addClass('in-process');
    });

    $(document).on('click','.pickup-btn-container .approved-icon.call', function(){
        $(this).addClass('in-process');
        $(this).find('button').focusout();
    });

    $(document).on('click','.driver-information .approved-icon.call', function(){
        $(this).addClass('in-process');
        $(this).find('button').focusout();
    });

    $(document).on('click','.ride-status .approved-icon.call.in-process', function(){
        $(this).removeClass('in-process');
    });

    $(document).on('click','.pickup-btn-container .approved-icon.call.in-process', function(){
        $(this).removeClass('in-process');
        $(this).find('button').focusout();
    });

    $(document).on('click','.driver-information .approved-icon.call.in-process', function(){
        $(this).removeClass('in-process');
        $(this).find('button').focusout();
    });

    $('.payment-options-intro-container').on('click', togglePaymentOptionsContainer);

    $('.payment-option-list li').on('click',function(){
        $('.payment-option-list li .check').addClass('hidden');
        $(this).find('.check').removeClass('hidden');
        $('.payment-options-text').html($(this).html()).find('.fa-check').remove();
        togglePaymentOptionsContainer();
    });

    $(document).on('click','.payment-ready-btn span.fa-times', togglePaymentOptionsContainer);

    $(document).on('click','.payment-ready-btn span.ready', function(){
        $('.payment-options-container').addClass('hidden');
        $('.ride-options-bottom').removeClass('hidden');
    });

    $('.default-payment-method-container').on('click', function(){
        $('.payment-options-container').removeClass('hidden');
        $('.ride-options-bottom').addClass('hidden');
    });

    $('.close-review').on('click', function(){
        $('.submit-review').addClass('hidden');
    });

    $('.menu-open').on('click',function(){
        var main_menu = $('.main-menu');
        main_menu.toggleClass('hidden-soft');
        $(this).toggleClass('closed');
        if($(this).hasClass('closed')) {
            main_menu.css('display','flex').animate({
                width: "toggle"
            }, 300);
        }
        else {
            main_menu.css('display','flex').hide().animate({
                width: "toggle"
            }, 300);
        }
        $('#load .fa-spin').hide();
        $('#load').css('visibility','visible');
    });

    $('.menu-close').on('click', function(){
        var main_menu = $('.main-menu');
        main_menu.hide().css('display','flex').animate({
            width: "toggle"
        }, 300);
        $('.menu-open').addClass('closed');
        $('#load .fa-spin').show();
        $('#load').css('visibility','hidden');
    });

    $(document).on('click', '.sign-in-item.border-bottom-light-grey', function(){
        $('.sign-in-item').removeClass('border-bottom-primary-100').addClass('border-bottom-light-grey');
        $(this).removeClass('border-bottom-light-grey').addClass('border-bottom-primary-100');
        var activateTab = $(this).data('class');
        $('.sign-up-form-container').addClass('hidden');
        $('.sign-up-form-container.'+activateTab).removeClass('hidden');
    });

    if($('.slider-container').length>0) {
        $('.slider-container').owlCarousel({
            autoPlay: true,
            autoPlayInterval: 10,
            responsiveClass:true,
            merge:true,
            responsive:{
                678:{
                    mergeFit:true
                },
                1000:{
                    mergeFit:false
                }
            } ,
            items:2,
            itemsDesktop : [1199,2],
            itemsDesktopSmall : [980,2],
            itemsTablet: [768,2],
            itemsTabletSmall: false,
            itemsMobile : [479,2]
        });
    }

    $('.settings-container .slider').on('click', function(){
        var className;
        var classNameRemove;
        if($(this).closest('.switch').find('input[type=checkbox]').prop('checked') == false){
            className = 'wrapper-active';
            classNameRemove = 'wrapper-disabled';
        }
        else{
            className= 'wrapper-disabled';
            classNameRemove = 'wrapper-active';
        }
        console.log($(this).closest('.setting-wrapper'));
        $(this).closest('.setting-wrapper').addClass(className).removeClass(classNameRemove);
        $(this).closest('.setting-wrapper-1').addClass(className).removeClass(classNameRemove);
        $(this).closest('.setting-wrapper-2').addClass(className).removeClass(classNameRemove);
        $(this).closest('.setting-wrapper-primary').addClass(className).removeClass(classNameRemove);
    });

    $('.change-request-status .slider').on('click', function(){
        $('.offline-notification').toggleClass('hidden');
        $('.request-ride-container').addClass('hidden');
        $('.go-to-pickup-btn').addClass('hidden');
        $('.request-ride-info').addClass('hidden');
        if($('.offline-notification').is(":visible")){
            hideMapRequestPin();
            $('.new-request-notification').addClass('hidden');
            $('.new-request').addClass('hidden');
            $('.meters-left-450').addClass('hidden');
            $('.meters-left-50').addClass('hidden');
            $('.new-request').addClass('hidden');
            $('.title').text('Offline');
            $('.tapped-car-info').addClass('hidden');
        }
        else{
            showMapRequestPin();
            $('.title').text('Online');
            $('.new-request').removeClass('hidden');
            $('.tapped-car-info').removeClass('hidden');
            $('.new-request-notification').removeClass('hidden');
        }
    });

    if(getUrlParameter('accepted')){
        $('.change-request-status .slider').trigger('click');
        $('.offline-notification').addClass('hidden');
        $('.new-request-notification').removeClass('hidden');
        $('.request-ride-container').addClass('hidden');
        $('.go-to-pickup-btn').addClass('hidden');
        $('.request-ride-info').addClass('hidden');
        setTimeout(showMapRequestPin,1000);
        $('.title').text('Online');

        $('.map-notification').addClass('hidden');
        multipleRoute(new google.maps.DirectionsService, new google.maps.DirectionsRenderer);
        $('.go-to-pickup-btn').removeClass('hidden');
    }

    $(".btn-accept").on('click',function(){
        $('.tapped-car-info').addClass('hidden');
        $('.map-notification').addClass('hidden');
        multipleRoute(new google.maps.DirectionsService, new google.maps.DirectionsRenderer);
        $('.go-to-pickup-btn').removeClass('hidden');
    });

    $('.go-to-pickup-btn').on('click', function(){
        $('.request-ride-info').removeClass('hidden');
        $('.meters-left-450').removeClass('hidden');
        $(this).addClass('hidden');
    });

    $('.pick-up.btn').on('click', function(){
       $('.pickup-btn-container').addClass('hidden');
    });

    $(document).on('click','.request-ride-info .slide-up', function(){
        $('.addresses-container').toggleClass('hidden');
        if($(this).hasClass('double-up')){
            $(this).find('img').attr('src', '../icons/downarrow.svg');
            $(this).removeClass('double-up').addClass('double-down');
        }
        else{
            $(this).find('img').attr('src', '../icons/uparrow.svg');
            $(this).removeClass('double-down').addClass('double-up');
        }
        if($('.drop-off-btn-container').is(":visible")) {
            $('.all-trip-fares').toggleClass('hidden');
        }
        if($('.finish-ride-btn-container').is(":visible")){
            $('.request-ride-info .all-trip-fares').toggleClass('hidden');
        }
        $('.request-ride-info .notification-container').toggleClass('addAddress');
        $(this).toggleClass('expanded');

    });

    $('.drop-off-btn-container').on('click', function(){
        $(this).addClass('hidden');
        $('.finish-ride-btn-container').removeClass('hidden');
        $('.addresses-container').removeClass('hidden');
        $('.all-trip-fares').removeClass('hidden');
        $('.tapped-car-info-header-icons').addClass('hidden');
    });

    $(document).on('click', '.pick-up',function(){
        $('.pickup-btn-container').addClass('hidden');
        $('.drop-off-btn-container').removeClass('hidden');
        $('.meters-left-450').addClass('hidden');
        $('.meters-left-50').removeClass('hidden');
        if(!$('.slide-up').hasClass('expanded')){
            $('.request-ride-info .addresses-container').addClass('border-bottom-0').removeClass('border-bottom-primary').addClass('hidden');
            $('.request-ride-info .all-trip-fares').addClass('hidden');
        }
        else{
            $('.request-ride-info .addresses-container').removeClass('border-bottom-primary').removeClass('hidden');
            $('.request-ride-info .all-trip-fares').removeClass('hidden');
        }
    });

    $('.cancel-trip').on('click', function(){
        $('.submit-review') .removeClass('hidden');
        $('.tapped-car-info').addClass('hidden');
    });

    $('.tapped-car-info .close').on('click',function(){
        $('.tapped-car-info').addClass('hidden');
    });

    $('#destination-input, #origin-input').on('focusin', function(){
        if($('.tap-on-car').is(":visible")){
            $('.tap-on-car').addClass('hidden');
        }
    });

    $('.submit-review .close-review').add('.submit-review .btn-primary').
    on('click', function(){
        $(this).closest('.map-input').find('input').val("");
        hideMarkers();
        $('.not-map>div').addClass('hidden');
        $('#origin-input').val('');
        $('#destination-input').val('');
    });

    $('.password-visibility').on('click', function(){
        var inputelement = $(this).closest('.input-group').find('input');
        if(inputelement.attr('type') == 'text'){
            inputelement.attr('type','password');
        }
        else{
            inputelement.attr('type','text');
        }
    });

    $('.load-more').on('click', function(){
        var counter = 0;
        $('.all-sales-history-items .sales-history-item').each(function(){
            if(counter<2) {
                $('.all-sales-history-items').append('<div class="display-flex align-items-center sales-history-item">'+$(this).html()+'</div>');
            }
            counter++;
        });
        window.scrollTo(0,document.body.scrollHeight);
    });

});

var requestedMarker;
var directionsDisplayMap;
var directionsServiceMap;

function togglePaymentOptionsContainer(){
    if($('.payment-options-intro-container').find('.fa-chevron-down').length == 0) {
        $('.payment-options-intro-container').find('.fa-chevron-up').removeClass('fa-chevron-up').addClass('fa-chevron-down');
        $('.payment-ready-btn span').text('Ready');
        $('.payment-ready-btn .close').removeClass('hidden').addClass('ready');
        $('.payment-option-list').addClass('hidden');
        $('.add-new-card-container').removeClass('hidden');
        $('.payment-options-main-text').removeClass('hidden');
    }
    else{
        $('.payment-options-intro-container').find('.fa-chevron-down').removeClass('fa-chevron-down').addClass('fa-chevron-up');
        $('.payment-ready-btn span').text('');
        $('.payment-ready-btn .close').addClass('hidden').removeClass('ready');
        $('.payment-option-list').removeClass('hidden');
        $('.add-new-card-container').addClass('hidden');
        $('.payment-options-main-text').addClass('hidden');
    }
}

function multipleRouteHide(){
    directionsDisplayMap.setMap(null);
}

function multipleRoute(directionsService, directionsDisplay){
    directionsDisplayMap = new google.maps.DirectionsRenderer({suppressMarkers:true});
    directionsDisplayMap.setOptions({
        polylineOptions: {
            strokeColor: '#FFD300',
            strokeWeight: 5,
            strokeOpacity:0
        }
    });
    directionsDisplayMap.setMap(map);
    directionsServiceMap = directionsService;
    var waypts = [{
        location:"157 Highland Street, Worcester, MA",
        stopover:true
    }];
    var coordinates = [{lat:42.270857,lng: -71.809520}];
    var icons = {
        end: new google.maps.MarkerImage(
            // URL
            '../icons/end.svg',
            // (width,height)
            new google.maps.Size(58, 53),
            // The origin point (x,y)
            new google.maps.Point(0, 0),
            // The anchor point (x,y)
            // new google.maps.Point(100, 8),
            // new google.maps.Size(25, 25)
        ),
        marker: new google.maps.MarkerImage(
            // URL
            '../icons/red-marker.svg',
            // (width,height)
            new google.maps.Size(28, 45),
            // The origin point (x,y)
            new google.maps.Point(0, 0),
            // The anchor point (x,y)
            new google.maps.Point(15, 28),
            // new google.maps.Size(28, 72)
        )
    };
    directionsService.route({
        origin: "100 Institute Rd, Worcester, MA",
        destination: "919 main street, Worcester, MA",
        waypoints: waypts,
        optimizeWaypoints: true,
        travelMode: 'DRIVING'
    }, function(response, status) {
        if (status === 'OK') {
            directionsDisplayMap.setDirections(response);
            renderDirectionsPolylines(response, map);
        } else {
            window.alert('Directions request failed due to ' + status);
        }
    });
    makeMarker({lat:42.251450, lng:-71.819469}, icons.end, "Route End");
    for(var i=0;i<coordinates.length;i++){
        makeMarker(coordinates[i], icons.marker,"Route Stop");
    }
}

function renderDirectionsPolylines(response,map){
    var bounds = new google.maps.LatLngBounds();
    var lineSymbol = {
        path: 'M 0,-1 0,1',
        strokeOpacity: 1,
        scale: 4
    };
    var polylineOptions = [{
        icons: [{
            "icon": {
                "path": 0,
                "scale": 3,
                "fillOpacity": 0.7,
                "fillColor": "#707070",
                "strokeOpacity": 0.8,
                "strokeColor": "#707070",
                "strokeWeight": 1
            },
            "repeat": "10px"
        }],
        strokeColor: "#000000",
        strokeOpacity: 0,
        strokeWeight: 5
    },{
        strokeColor: '#FFD300',
        strokeWeight: 5
    }];
    var legs = response.routes[0].legs;
    for (i = 0; i < legs.length; i++) {
        var steps = legs[i].steps;
        for (j = 0; j < steps.length; j++) {
            var nextSegment = steps[j].path;
            var stepPolyline = new google.maps.Polyline(i>0 ? polylineOptions[1] : polylineOptions[0]) ;
            for (k = 0; k < nextSegment.length; k++) {
                stepPolyline.getPath().push(nextSegment[k]);
                bounds.extend(nextSegment[k]);
            }
            stepPolyline.setMap(map);
        }
    }
    // map.fitBounds(bounds);
}

function sendChat(){
    var text = $('.message-input').val();
    $('.message-input').val('');
    if(text.trim().length>0) {
        var newDom = "<div class='left-align-message'>" + $('.left-align-message.example').html() + "</div>";
        $('.chat-container').append(newDom);
        $('.chat-container .left-align-message:last-child').removeClass('hidden example').find('.message-content').text(text);
        $('.chat-container').scrollTop($('.chat-container').prop("scrollHeight"));
    }
}

function fromSetRouteToAddRoute(){
    $('.title').text("Add Route");
    $('.gm-style > div:first-child').show("slow");
    $('.back-to-map').addClass('hidden');
}
var map;
var directionsDisplay;

function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        mapTypeControl: false,
        center: {lat: 42.1945, lng: -71.8356},
        zoom: 13,
        fullscreenControl: false,
    });
    directionsDisplay = new google.maps.DirectionsRenderer();
    new AutocompleteDirectionsHandler(map);
    $(window).on('resize', function(){
        google.maps.event.trigger(map, 'resize');
    })
}

function hideMapRequestPin(){
    requestedMarker.setVisible(false);
    $('.tapped-car-info').addClass('hidden');

}

function showMapRequestPin(){
    var icons = {
        request: new google.maps.MarkerImage(
            // URL
            '../icons/car-start-position.svg',
            // (width,height)
            new google.maps.Size(36, 28),
            // The origin point (x,y)
            new google.maps.Point(0, 0),
            // The anchor point (x,y)
            new google.maps.Point(0, 8),
            new google.maps.Size(36, 28)
        )
    };
    makeMarker( {lat:42.274006, lng:-71.810181}, icons.request, "Request Pin", false);
    setTimeout(function() {
        if (!$("img[src='../icons/car-start-position.svg']").parent().hasClass('pulse')) {
            $("img[src='../icons/car-start-position.svg']").parent().addClass('pulse').css('opacity',1);
        }
    },600);
}

/**
 * @constructor
 */
function AutocompleteDirectionsHandler(map) {
    this.map = map;
    this.originPlaceId = null;
    this.destinationPlaceId = null;
    this.travelMode = 'DRIVING';
    this.directionsService = new google.maps.DirectionsService;
    this.directionsDisplayMap = new google.maps.DirectionsRenderer({suppressMarkers:true});
    this.directionsDisplayMap.setOptions({
        polylineOptions: {
            strokeColor: '#FFD300',
            strokeWeight: 5
        }
    });
    this.directionsDisplayMap.setMap(map);
    var self = this;
    $('.map-input .remove')
        .add('.submit-review .close-review').
    add('.submit-review .btn-primary').on('click', function(){
        self.directionsDisplayMap.setMap(null);
        if($(this).closest('.map-input').find('input').attr('id') == 'origin-input') {
            self.originPlaceId = null;
        }
        else {
            self.destinationPlaceId = null;
        }
    });
    var originInput = document.getElementById('origin-input');
    var originInputContainer = document.getElementById('origin-input-container');
    var destinationInput = document.getElementById('destination-input');
    var destinationInputContainer = document.getElementById('destination-input-container');

    var originAutocomplete = new google.maps.places.Autocomplete(originInput);
    // originInputContainer.appendChild(originAutocomplete);
    // Specify just the place data fields that you need.
    originAutocomplete.setFields(['place_id']);

    var destinationAutocomplete =
        new google.maps.places.Autocomplete(destinationInput);
    // Specify just the place data fields that you need.
    destinationAutocomplete.setFields(['place_id']);

    this.setupPlaceChangedListener(originAutocomplete, 'ORIG');
    this.setupPlaceChangedListener(destinationAutocomplete, 'DEST');

    this.map.controls[google.maps.ControlPosition.TOP_CENTER].push(originInputContainer);
}

AutocompleteDirectionsHandler.prototype.setupPlaceChangedListener = function(
    autocomplete, mode) {
    var me = this;
    autocomplete.bindTo('bounds', this.map);

    autocomplete.addListener('place_changed', function() {
        var place = autocomplete.getPlace();

        if (!place.place_id) {
            $('.request-ride-btn').addClass('hidden');
            return;
        }
        if (mode === 'ORIG') {
            me.originPlaceId = place.place_id;
        } else {
            me.destinationPlaceId = place.place_id;
        }
        me.route();
    });
};

AutocompleteDirectionsHandler.prototype.route = function() {
    if (!this.originPlaceId || !this.destinationPlaceId) {
        $('.request-ride-btn').addClass('hidden');
        return;
    }
    var me = this;
    $('.request-ride-btn').removeClass('hidden');
    this.directionsService.route(
        {
            origin: "157 Highland Street, Worcester MA",
            destination: "919 Main Street, Worcester MA",
            travelMode: this.travelMode
        },
        function(response, status) {
            if (status === 'OK') {
                var icons = {
                    start: new google.maps.MarkerImage(
                        // URL
                        '../icons/circle.svg',
                        // (width,height)
                        new google.maps.Size( 26, 21),
                        // The origin point (x,y)
                        new google.maps.Point( 0,0 ),
                        // The anchor point (x,y)
                        new google.maps.Point( 13, 16 ),
                        new google.maps.Size( 26, 21 )
                    ),
                    end: new google.maps.MarkerImage(
                        // URL
                        '../images/end.png',
                        // (width,height)
                        new google.maps.Size( 58, 53 ),
                        // The origin point (x,y)
                        new google.maps.Point( 0, 0 ),
                        // The anchor point (x,y)
                        new google.maps.Point( 22, 32 )
                    )
                };
                me.directionsDisplayMap.setMap(map);
                me.directionsDisplayMap.setOptions({
                    polylineOptions: {
                        strokeColor: '#FFD300',
                        strokeWeight: 5
                    }
                });
                me.directionsDisplayMap.setDirections(response);
                var leg = response.routes[0].legs[0];
                makeMarker( leg.start_location, icons.start, "Route Start" );
                makeMarker( leg.end_location, icons.end, 'Route End' );
                setTimeout(function() {
                    var currents = $("#map img[src='../icons/circle.svg']").parent();
                    currents.each(function(index, current) {
                        if (!$(current).hasClass('pulse current-location') && !$(current).hasClass('map-input-icon')) {
                            $(current).addClass('pulse current-location').css('opacity', 1);
                        }
                    });
                },600);
            } else {
                window.alert('Directions request failed due to ' + status);
            }

        }
    );
    map.setZoom(12);
    $(window).trigger('resize');
};
var markers = [];

function hideMarkers() {
    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(null); //Remove the marker from the map
    }
}

function makeMarker( position, icon, title, listener=false) {
    var marker = new google.maps.Marker({
        position: position,
        map: map,
        icon: icon,
        title: title,
        animation: google.maps.Animation.DROP,
    });
    markers.push(marker);
    var addListenerToMarker = function(myMarker){
        marker.addListener('click', function() {
            $('.tapped-car-info').removeClass('hidden');
        });
    }
    if(listener){
        // add a closure for listener manage
        addListenerToMarker(marker);

    }
    map.setCenter(position);
    map.setZoom(12);
    requestedMarker = marker;
}

var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = window.location.search.substring(1),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
        }
    }
};