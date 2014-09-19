#---------------------------------------------------------------------------------------------------
#http://wiki.servicenow.com/index.php?title=Perl_Web_Services_Client_Examples
#---------------------------------------------------------------------------------------------------

#!/usr/bin/perl -w
 
# declare usage of SOAP::Lite
use SOAP::Lite;
 
sub SOAP::Transport::HTTP::Client::get_basic_credentials {
   return 'pruser' => 'pruser'; 
}
 
# declare the SOAP endpoint here
my $soap = SOAP::Lite
    -> proxy('http://192.168.0.5:8484/bpm-ejb-1.0-SNAPSHOT/HelloWorldWS?wsdl');
 
# calling the function
my $method = SOAP::Data->name('triggerWebserviceSimple')->attr({xmlns => 'http://wstest.logic.ejb.bpmtest.gravitex.de/'}); 

my @params = ();
 
# invoke the SOAP call
$soap->call($method => @params);