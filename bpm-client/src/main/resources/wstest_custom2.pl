#---------------------------------------------------------------------------------------------------
#http://www.ebi.ac.uk/Tools/webservices/tutorials/06_programming/perl/soap/soap-lite
#---------------------------------------------------------------------------------------------------

# SOAP::Lite module
use SOAP::Lite;
 
# WSDbfetch WSDL URL
my $WSDL = 'http://192.168.0.5:8484/bpm-ejb-1.0-SNAPSHOT/HelloWorldWS?wsdl';
# Default option values
my ($query, $format, $style) = ('uniprot:wap_rat', 'fasta', 'raw');
 
# Create a service proxy from the WSDL. Specifying a SOAP fault handler which maps a fault to a die.
my $soap = SOAP::Lite
    ->service($WSDL)
    ->on_fault(sub { # SOAP fault handler
        my $soap = shift;
        my $res = shift;
        # Map faults to exceptions
        if(ref($res) eq '') {
            die($res);
        } else {
            die($res->faultstring);
        }
        return new SOAP::SOM;
	       }
    );
 
# Perform the query
my $result = $soap->triggerWebserviceSimple();
# Output the result
print $result;