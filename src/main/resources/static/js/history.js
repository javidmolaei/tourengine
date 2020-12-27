$(document).ready(function(){
});
var map1;
var markerArray = [];
function initMap1() {
    var myOptions = {
        zoom: 14,
        disableDefaultUI: true
    };
    var oneMoreMapExists = true;
    var i =1;
    var originDestinationObj = [
        {
            origin: "157 Highland Street, Worcester, MA",
            destination: "919 Main Street, Worcester, MA"
        },
        {
            origin: "315 Avenue C, New York, NY",
            destination: "Old Tbilisi, New York, NY"
        },
        {
            origin: "555 Middlefield rd, Mountain View, CA",
            destination: "Palo Alto, CA"
        }
    ];
    while(oneMoreMapExists){
        if($('#map'+i).length>0){
            var directionsDisplay1 = new google.maps.DirectionsRenderer;
            var directionsService1 = new google.maps.DirectionsService;
            var map1 = new google.maps.Map(document.getElementById('map'+i), myOptions);
            directionsDisplay1.setMap(map1);
            calculateAndDisplayRoute(originDestinationObj[i-1].origin,
                originDestinationObj[i-1].destination,
                directionsService1,
                directionsDisplay1,
                markerArray);
            i++;
        }
        else{
            oneMoreMapExists = false;
        }
    }
}

function calculateAndDisplayRoute(origin,destination, directionsService, directionsDisplay, markerArray) {
    // for (var i = 0; i < markerArray.length; i++) {
    //     markerArray[i].setMap(null);
    // }
    var icons = {
        start: new google.maps.MarkerImage(
            // URL
            '../icons/circle.svg',
            // (width,height)
            new google.maps.Size( 16, 16 ),
            // The origin point (x,y)
            new google.maps.Point( 0, 0 ),
            // The anchor point (x,y)
            new google.maps.Point( 0, 8 )
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
    directionsService.route({
        origin: origin,
        destination: destination,
        travelMode: google.maps.TravelMode['DRIVING'],
        provideRouteAlternatives: true
    }, function (response, status) {
        if (status == 'OK') {
            directionsDisplay.setDirections(response);
            var leg = response.routes[0].legs[0];
            console.log(response);
            makeMarker1(leg.start_location, icons.start, "Route Start");
            makeMarker1(leg.end_location, icons.end, 'Route End');
        } else {
            window.alert('Directions request failed due to ' + status);
        }
    });
}
// }
function makeMarker1( position, icon, title, listener=false) {
    console.log(position);
    console.log(icon);
    var marker = new google.maps.Marker({
        position: position,
        map: map1,
        icon: icon,
        title: title,
        animation: google.maps.Animation.DROP,
    });
    markerArray.push(marker);
}