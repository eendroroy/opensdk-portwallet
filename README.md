# PortWallet SDK

![Java CI with Gradle](https://github.com/eendroroy/opensdk-portwallet/workflows/Tests/badge.svg)
[![GitHub tag](https://img.shields.io/github/tag/eendroroy/opensdk-portwallet.svg)](https://github.com/eendroroy/opensdk-portwallet/tags)

[![Contributors](https://img.shields.io/github/contributors/eendroroy/opensdk-portwallet.svg)](https://github.com/eendroroy/opensdk-portwallet/graphs/contributors)
[![GitHub last commit (branch)](https://img.shields.io/github/last-commit/eendroroy/opensdk-portwallet/master.svg)](https://github.com/eendroroy/opensdk-portwallet)
[![license](https://img.shields.io/github/license/eendroroy/opensdk-portwallet.svg)](https://github.com/eendroroy/opensdk-portwallet/blob/master/LICENSE)
[![GitHub issues](https://img.shields.io/github/issues/eendroroy/opensdk-portwallet.svg)](https://github.com/eendroroy/opensdk-portwallet/issues)
[![GitHub closed issues](https://img.shields.io/github/issues-closed/eendroroy/opensdk-portwallet.svg)](https://github.com/eendroroy/opensdk-portwallet/issues?q=is%3Aissue+is%3Aclosed)
[![GitHub pull requests](https://img.shields.io/github/issues-pr/eendroroy/opensdk-portwallet.svg)](https://github.com/eendroroy/opensdk-portwallet/pulls)
[![GitHub closed pull requests](https://img.shields.io/github/issues-pr-closed/eendroroy/opensdk-portwallet.svg)](https://github.com/eendroroy/opensdk-portwallet/pulls?q=is%3Apr+is%3Aclosed)


Implementation of [PortWallet PaymentGateway API](https://developer.portwallet.com/documentation-v2.php)

## Usage

### Add Dependency

*Maven*

```xml

<dependency>
    <groupId>io.github.eendroroy</groupId>
    <artifactId>opensdk-portwallet</artifactId>
    <version>1.0.0-beta1</version>
</dependency>
```

*Gradle*s

```groovy
dependencies {
    implementation("io.github.eendroroy:opensdk-portwallet:1.0.0-beta1")
}
```

_Note:_ Check [releases](https://github.com/eendroroy/opensdk-portwallet/releases) for latest version.

### Create configuration

```java
public class Configuration implements PWConfiguration {
    @Override
    public String getBaseUrl() {
        return "https://api-sandbox.portwallet.com";
    }

    @Override
    public String getAppKey() {
        return "APP_KEY";
    }

    @Override
    public String getAppSecret() {
        return "APP_SECRET";
    }

    @Override
    public String getAccept() {
        return "application/json";
    }

    @Override
    public String getContentType() {
        return "application/json";
    }

    @Override
    public String getIpnUrl() {
        return "http://example.com/view/portwallet/redirect";
    }

    @Override
    public String getRedirectUrl() {
        return "http://example.com/api/v1/portwallet/ipn";
    }

    @Override
    public Boolean getAcceptUnsafeSSL() {
        return false;
    }
}
```

### Create optional Interceptor

```java
public class LoggingInterceptor extends AbstractPWInterceptor {
    @Override
    public Request interceptRequest(Request request) {
        System.out.println(rawRequestBody(request));
        return request;
    }

    @Override
    public Response interceptResponse(Response response) {
        System.out.println(rawResponseBody(response));
        return response;
    }
}
```

### Make api call

```java
public class Main {
    public static void main(String[] args) throws Exception {
        PWConfiguration configuration = new Configuration();
        PWInterceptor interceptor  = new LoggingInterceptor();
        PWApiClient client = new PWApiClient(configuration, interceptor);

        InvoiceRequest request = new InvoiceRequest(
                new OrderRequest(
                        100.0,
                        "BDT",
                        "https://example.con/redirect",
                        "https://example.con/redirect",
                        "MY_REFERENCE"
                ),
                new ProductRequest("MY_PRODUCT", "It's My Product"),
                new BillingRequest(
                        new CustomerRequest(
                                "Customer Name",
                                "customer@example.com",
                                "8801500000000",
                                new AddressRequest()
                        )
                ),
                new ShippingRequest(
                        new CustomerRequest(
                                "Customer Name",
                                "customer@example.com",
                                "8801500000000",
                                new AddressRequest()
                        )
                ),
                new DiscountRequest(1, Arrays.asList("MyCode1", "MyCode2")),
                new EmiRequest(1, Arrays.asList(3, 6, 9, 12, 24, 36)),
                Arrays.asList(
                        Collections.singletonMap("property1", "value1"),
                        Collections.singletonMap("property2", "value2")
                )
        );

        InvoiceResponse response = client.createInvoice(request);

        assert response != null;
        System.out.println(response);

    }
}
```

## Contributing

Bug reports and pull requests are welcome on GitHub at [opensdk-portwallet](https://github.com/eendroroy/opensdk-portwallet) repository. This
project is intended to be a safe, welcoming space for collaboration, and contributors are expected to adhere to the
[Contributor Covenant](http://contributor-covenant.org) code of conduct.

1. Fork it ( https://github.com/eendroroy/opensdk-portwallet/fork )
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Add some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create a new Pull Request

## Author

* **indrajit** - *Owner* - [eendroroy](https://github.com/eendroroy)

## License

The project is available as open source under the terms of the [MIT License](http://opensource.org/licenses/MIT).

