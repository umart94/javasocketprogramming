package com.umartariq;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Main.java created by umartariq on 26/06/2020
 * 12:29 PM inside the package - com.umartariq
 */
public class Main {



    /*
    //Universal Resource Identifier

    URI is an identifier that might not provide enough information to access the resource it identifies



    A URL is an identifier that includes information about how to access the resource it identifies.

    A URI can specify a relative path, but a URL HAS TO BE AN ABSOLUTE PATH, because when we use the URL
    URL HAS TO CONTAIN ENOUGH INFORMATION TO locate and access the resource it identifies.

    WITH JAVA.NET, WE HAVE TO USE URI UNTIL WE ACTUALLY WANT TO ACCESS A RESOURCE , AND THEN CONVERT THE URI TO URL

    main classes we use are URI,URL,URLConnection and HttpURLConnection


    URI contains 9 components :
    1. scheme
    2. scheme-specific-part
    3. authority
    4. user-info
    5. host
    6. port
    7. path
    8. query
    9. fragment

    scheme:[[//user[:password]@]host[:port]][/path][?query][#fragment]

    URI that specifies scheme is called absolute URI
    uri that does not specify scheme is called relative URI



    //https://www.w3.org/TR/uri-clarification/

        1 URI Partitioning
There is some confusion in the web community over the partitioning of URI space, specifically, the relationship among the concepts of URL, URN, and URI. The confusion owes to the incompatibility between two different views of URI partitioning, which we call the "classical" and "contemporary" views.

1.1 Classical View
During the early years of discussion of web identifiers (early to mid 90s), people assumed that an identifer type would be cast into one of two (or possibly more) classes. An identifier might specify the location of a resource (a URL) or its name (a URN) independent of location. Thus a URI was either a URL or a URN. There was discussion about generalizing this by addition of a discrete number of additional classes; for example, a URI might point to metadata rather than the resource itself, in which case the URI would be a URC (citation). URI space was thus viewed as partitioned into subspaces: URL and URN, and additional subspaces, to be defined. The only such additional space ever proposed was URC and there never was any buy-in; so without loss of generality it's reasonable to say that URI space was thought to be partitioned into two classes: URL and URN. Thus for example, "http:" was a URL scheme, and "isbn:" would (someday) be a URN scheme. Any new scheme would be cast into one or the other of these two classes.

1.2 Contemporary View
Over time, the importance of this additional level of hierarchy seemed to lessen; the view became that an individual scheme does not need to be cast into one of a discrete set of URI types such as "URL", "URN", "URC", etc. Web-identifer schemes are in general URI schemes; a given URI scheme may define subspaces. Thus "http:" is a URI scheme. "urn:" is also a URI scheme; it defines subspaces, called "namespaces". For example, the set of URNs of the form "urn:isbn:n-nn-nnnnnn-n" is a URN namespace. ("isbn" is an URN namespace identifier. It is not a "URN scheme" nor a "URI scheme").

Further according to the contemporary view, the term "URL" does not refer to a formal partition of URI space; rather, URL is a useful but informal concept: a URL is a type of URI that identifies a resource via a representation of its primary access mechanism (e.g., its network "location"), rather than by some other attributes it may have. Thus as we noted, "http:" is a URI scheme. An http URI is a URL. The phrase "URL scheme" is now used infrequently, usually to refer to some subclass of URI schemes which exclude URNs.

1.3 Confusion
The body of documents (RFCs, etc) covering URI architecture, syntax, registration, etc., spans both the classical and contemporary periods. People who are well-versed in URI matters tend to use "URL" and "URI" in ways that seem to be interchangable. Among these experts, this isn't a problem. But among the Internet community at large, it is. People are not convinced that URI and URL mean the same thing, in documents where they (apparently) do. When one sees an RFC that talks about URI schemes (e.g. [RFC 2396]), another that talks about URL schemes (e.g. [RFC 2717]), and yet another that talks of URN schemes ([RFC 2276]) it is natural to wonder what's the difference, and how they relate to one another. While RFC 2396 1.2 attempts to address the distinction between URIs, URLs and URNs, it has not been successful in clearing up the confusion.

2 Registration
This section examines the state of registration of URI schemes and URN namespaces and the mechanisms by which registration currently occurs.

2.1 URI Schemes
2.1.1 Registered URI schemes
The official register of URI scheme names is maintained by IANA, at http://www.iana.org/assignments/uri-schemes . For each scheme, the RFC that defines the scheme is listed, for example "http:" is defined by [RFC 2616]. The table currently lists 30 schemes. In addition, there are a few "reserved" scheme names; at one point in time these were intended to become registered schemes but have since been dropped.

2.1.2 Unregistered URI Schemes
We distinguish between public (unregistered) and private schemes. A public scheme (registered or not), is one for which there is some public document describing it.

2.1.2.1 Public Unregistered Schemes
Dan Connolly maintains a list of known, public URI schemes, both registered and un-registered, a total of 84 schemes. 50 or so of these are unregistered (not listed in the IANA register). Some may be obsolete (for example, it appears that "phone", is obsolete, superceded by "tel"). Some have an RFC, but are not included in the IANA list.

2.1.2.2 Private Schemes
It's probably impossible to determine all of these, and it's not clear that it's worthwhile to try, except perhaps to get some idea of their number. In the minutes of the August 1997 IETF meeting is the observation that there may be 20-40 in use at Microsoft, with 2-3 being added a day, and that WebTV has 24, with 6 added per year.

2.1.3 Registration of URI Schemes
[RFC 2717] specifies procedures for registering scheme names, and points to [RFC 2718] which supplies guidelines. RFC 2717 describes an organization of schemes into "trees".

2.1.3.1 IETF Tree
The IETF tree is intended for schemes of general interest to the Internet community, and which require a substantive review and approval process. Registration in the IETF tree requires publication of the scheme syntax and semantics in an RFC.

2.1.3.2 Other Trees
Although RFC 2717 describes "alternative trees", no alternative trees have been registered to date, although a vendor-supplied tree ("vnd") is pending. URI schemes in alternative trees will be distinguished because they will have a "." in the scheme name.

2.2 URN Namespaces
A URN namespace is identified by a "Namespace ID", NID, which is registered with IANA (see 2.2.4 Registration Procedures for URN NIDs).

2.2.1 Registered URN NIDs
There are two categories of registered URN NIDs:

Informal: These are of the form "urn-<number>" where <number> is assigned by IANA. There are three registered in this category (urn-1, urn-2, and urn-3).

Formal: The official list of registered NIDs is kept by IANA at http://www.iana.org/assignments/urn-namespaces. Currently it lists eight registered NIDs:

'ietf', defined by [RFC 2648], URN Namespace for IETF Documents

'pin', defined by [RFC 3043], The Network Solutions Personal Internet Name (PIN): A URN Namespace for People and Organizations

'issn' defined by [RFC 3043], Using The ISSN as URN within an ISSN-URN Namespace

'oid' defined by [RFC 3061], A URN Namespace of Object Identifiers

'newsml' defined by [RFC 3085], URN Namespace for NewsML Resources

'oasis' defined by [RFC 3121], A URN Namespace for OASIS

'xmlorg' defined by [RFC 3120], A URN Namespace for XML.org

'publicid' defined by [RFC 3151], A URN Namespace for Public Identifiers

2.2.2 Pending URN NIDs
There are a number of pending URN NID registration requests but there is no reliable way to discover them, or their status. For example, 'isbn' and 'nbn' have been approved by the IESG and are in the RFC Editor's queue. 'isbn', as a potential URN namespace (or URI scheme), in particular has been a source of much speculation and confusion over several years. It would be helpful if there were some formal means to track the status of NID requests such as 'isbn'.

2.2.3 Unregistered NIDs
In the "unregistered" category (besides the experimental case, not described in this paper) there are bonafide NIDs that just haven't bothered to even explore the process of registration.The most prominent that comes to mind is 'hdl'. In the case of 'hdl', it has been speculated that this scheme has not been registered because it is not clear to the owners whether it should be registered as a URI scheme or as a URN namespace.

2.2.4 Registration Procedures for URN NIDs
[RFC 2611] describes the mechanism to obtain an NID for a URN namespace, which is registered with IANA.

A request for an NID should describe features including: structural characteristic of identifiers (for example, features relevant to caching/shortcuts approaches); specific character encoding rules (e.g., which character should be used for single-quotes); RFCs, standards, etc, that explains the namespace structure; identifier uniqueness considerations; delegation of assignment authority, including how to become an assigner of identifiers; identifier persistence considerations; quality of service considerations; process for identifier resolution; rules for lexical equivalence; any special considerations required for conforming with the URN syntax (particularly applicable in the case of legacy naming systems); validation mechanisms (determining whether a given string is currently a validly-assigned URN; and scope (for example,"United States social security numbers").

3 Additional URI Issues
There are additional unresolved URI issues, not considered by this paper, which we hope will be addressed by a follow-on effort. We have not attempted to completely enumerate these issues, however, they include (but are not limited to) the following:

The use of URIs as identifiers that don't actually identify network resources (for example they identify an abstract object such as an XML schema, or a physical object such as a book or even a person).

IRIs (International Resource Identifiers): the extension of URI syntax to non-ASCII.



     */

    /*
    A Uniform Resource Name (URN) is a URI that identifies a resource by name in a particular namespace. A URN may be used to talk about a resource without implying its location or how to access it. For example, in the International Standard Book Number (ISBN) system, ISBN 0-486-27557-4 identifies a specific edition of Shakespeare's play Romeo and Juliet. The URN for that edition would be urn:isbn:0-486-27557-4. However, it gives no information as to where to find a copy of that book.

A Uniform Resource Locator (URL) is a URI that specifies the means of acting upon or obtaining the representation of a resource, i.e. specifying both its primary access mechanism and network location. For example, the URL http://example.org/wiki/Main_Page refers to a resource identified as /wiki/Main_Page, whose representation, in the form of HTML and related code, is obtainable via the Hypertext Transfer Protocol (http:) from a network host whose domain name is example.org.

A URN may be compared to a person's name, while a URL may be compared to their street address. In other words, a URN identifies an item and a URL provides a method for finding it.

Technical publications, especially standards produced by the IETF and by the W3C, normally reflect a view outlined in a W3C Recommendation of 2001, which acknowledges the precedence of the term URI rather than endorsing any formal subdivision into URL and URN.
URL is a useful but informal concept: a URL is a type of URI that identifies a resource via a representation of its primary access mechanism (e.g., its network "location"), rather than by some other attributes it may have.[2]

As such, a URL is simply a URI that happens to point to a resource over a network.[a][3] However, in non-technical contexts and in software for the World Wide Web, the term "URL" remains widely used. Additionally, the term "web address" (which has no formal definition) often occurs in non-technical publications as a synonym for a URI that uses the http or https schemes. Such assumptions can lead to confusion, for example, in the case of XML namespaces that have a visual similarity to resolvable URIs.

Specifications produced by the WHATWG prefer URL over URI, and so newer HTML5 APIs use URL over URI.[4]
Standardize on the term URL. URI and IRI [Internationalized Resource Identifier] are just confusing. In practice a single algorithm is used for both so keeping them distinct is not helping anyone. URL also easily wins the search result popularity contest.[5]

While most URI schemes were originally designed to be used with a particular protocol, and often have the same name, they are semantically different from protocols. For example, the scheme http is generally used for interacting with web resources using HTTP, but the scheme file has no protocol.




     */


    //note: import the java.net classes
    public static void main(String[] args) {
        try {
            //query for phones table of catalogue db
            //URI equal toURL as URL and URI specifies scheme, so it specifies absolute path , complete uri syntax.
            //URI uriobject = new URI("db://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");


         /*   URI uriobject = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
            URL urlobject = uriobject.toURL();
            System.out.println("URL = "+urlobject);
            System.out.println("Scheme = "+ uriobject.getScheme());// we can write our own scheme, but it is recommended not to do so to avoid naming conflicts
            System.out.println("Scheme-Specific Part = "+ uriobject.getSchemeSpecificPart());// everything after scheme and before the fragment
            System.out.println("Auhtority = "+ uriobject.getAuthority());// contains host,optionally username,password,portnumber
            System.out.println("User Info = "+ uriobject.getUserInfo());// credentials
            System.out.println("Host = "+ uriobject.getHost());// host
            System.out.println("Port = "+ uriobject.getPort());// port number
            System.out.println("Path = "+ uriobject.getPath());// path to resource on the host (database=resource, path points to specific table(phones) in the database
            System.out.println("Query = "+ uriobject.getQuery());// query parameters start with = chain with & query1=value1&query2=value2
            System.out.println("Fragment = "+ uriobject.getFragment());// fragment is secondary resource, if uri pointed to webpage its just html section headings
*/
            /*
            Malformed URL
            URI uriobject = new URI("db://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
            unknown protocol: db
            */

           /*
           java.lang.IllegalArgumentException: URI is not absolute
            URI uriobject2 = new URI("/catalogue/phones?os=android#samsung");
            URL urlobject2 = uriobject2.toURL();
            System.out.println("URL = "+urlobject2);
            //incomplete URI , there is not enough information such as scheme and other credentials
            //we cannot access resources this way
            */

           //when you want to access resource, use the full url with scheme
            ///when you want to use relative uris, use them with a baseURI
            //the baseURI contains host info, will point to the root of relative path.
            //if host changes, we only change the BaseURI

            /*
            Problem: Changed Host
            we should use relative URIs and baseURIS
            so that when we change host we only change the baseURI variable

            if we used absolute URIs everywhere, and then changed host, we would need to update each variable with updated information about host.
             */

            //URI baseURI = new URI("http://username:password@myserver.com:5000");
          /*  URI baseURI = new URI("http://username:password@mynewserver2020.com:5000");
            URI relativeURI1 = new URI("/catalogue/phones?os=android#samsung");
            URI relativeURI2 = new URI("/catalogue/tv?manufacturer=samsung");
            URI relativeURI3 = new URI("/stores/locations?zip=12345");
            URI resolvedURI1 = baseURI.resolve(relativeURI1);
            URI resolvedURI2 = baseURI.resolve(relativeURI2);
            URI resolvedURI3 = baseURI.resolve(relativeURI3);
            URL baseandrelative1 = resolvedURI1.toURL();
            URL baseandrelative2 = resolvedURI2.toURL();
            URL baseandrelative3 = resolvedURI3.toURL();
            System.out.println(" baseandrelative1 URL"+baseandrelative1);
            System.out.println("baseandrelative2 URL "+baseandrelative2);
            System.out.println("baseandrelative3 URL "+baseandrelative3);

            //to return the relative uri portion, AFTER you have combined those two portions, we use relativize function.
            //BaseURI = baseURI = new URI("http://username:password@mynewserver2020.com:5000");
            //relativeURI2 = new URI("/catalogue/tv?manufacturer=samsung");
            //URL baseandrelative2 = resolvedURI2.toURL();
            URI relativizedURI = baseURI.relativize(resolvedURI2);
            System.out.println("Relativized URI " + relativizedURI);
            //relativizedURI = baseURI.relativize(resolvedURI2);
            //Relativized URI = catalogue/tv?manufacturer=samsung*/



            //to check whether the URL follows the correct syntax.
        /*    URL websiteURL = new URL("http://example.org");
            URI websiteURLtoURI = websiteURL.toURI();
            System.out.println("Scheme = "+ websiteURLtoURI.getScheme());// we can write our own scheme, but it is recommended not to do so to avoid naming conflicts
            System.out.println("Scheme-Specific Part = "+ websiteURLtoURI.getSchemeSpecificPart());// everything after scheme and before the fragment
            System.out.println("Auhtority = "+ websiteURLtoURI.getAuthority());// contains host,optionally username,password,portnumber
            System.out.println("User Info = "+ websiteURLtoURI.getUserInfo());// credentials
            System.out.println("Host = "+ websiteURLtoURI.getHost());// host
            System.out.println("Port = "+ websiteURLtoURI.getPort());// port number
            System.out.println("Path = "+ websiteURLtoURI.getPath());// path to resource on the host (database=resource, path points to specific table(phones) in the database
            System.out.println("Query = "+ websiteURLtoURI.getQuery());// query parameters start with = chain with & query1=value1&query2=value2
            System.out.println("Fragment = "+ websiteURLtoURI.getFragment());// fragment is secondary resource, if uri pointed to webpage its just html section headings
*/
            /*
            returns

            Scheme = http
Scheme-Specific Part = //example.org
Auhtority = example.org
User Info = null
Host = example.org
Port = -1
Path =
Query = null
Fragment = null
             */




        }catch(URISyntaxException e){
            System.out.println("URI Bad Syntax \n"+e.getMessage());
        }catch(MalformedURLException e){
            System.out.println("Malformed URL \n"+e.getMessage());

        }
    }








}
