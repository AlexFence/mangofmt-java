load("@rules_java//java:defs.bzl", "java_library", "java_test")

package(default_visibility = ["//visibility:public"])

java_library(
    name = "lib",
    srcs = glob(["src/main/java/rocks/pizzaandcoffee/mangofmt/**/*.java"]),
    deps = [
            "@maven//:net_java_dev_jna_jna",
    ],
)

java_test(
    name = "tests",
    srcs = glob(["src/test/java/rocks/pizzaandcoffee/mangofmt/**/*.java"]),
    test_class = "rocks.pizzaandcoffee.mangofmt.MangoFileTest",

    deps = [
        ":lib",
        "@maven//:junit_junit",
    ],
)


