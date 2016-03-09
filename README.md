# Distance tracking
General architecture of this project builded by 3 several parts: UI, Data and Domain with Service. 


Service it is networking,  in our case service comunicates with other service, it is LocationManager, and application gets location data. 

Location should be shown in correct format, so we made it on Domain level and make calculation to get correct distance. 

Then distance saving in DB, Data layer, and finally we show it on presentation level in our UI part of application. 

I was made this decision because it is easy to test and adaptable. Finally, service is very easy change to any other provider also it gives chance for us to work with current data in any phase of device and continue to calculate it after. 

