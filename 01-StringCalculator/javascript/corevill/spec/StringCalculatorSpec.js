describe("String calculator", function() {
    let stringCalculator;

    beforeEach(function() {
    stringCalculator = new StringCalculator();
    });

    it("Empty string", function () {
      expect(stringCalculator.add("")).toEqual(0);
    });

    it("One number", function () {
      expect(stringCalculator.add("1")).toEqual(1);
    });

    it("Two numbers", function () {
      expect(stringCalculator.add("1,2")).toEqual(3);
    });

    it("More than two numbers", function () {
      expect(stringCalculator.add("1,2,3,4")).toEqual(10);
    });

    it("Two separators ',' and '\\n'", function () {
      expect(stringCalculator.add("1\n2,3")).toEqual(6);
    });

    it("Differents delimitators", function () {
      expect(stringCalculator.add("//;\n1;2")).toEqual(3);
    });

    it("Negative numbers are not valids", function () {
        expect(function(){ stringCalculator.add("-1,-2") }).toThrow(new Error("Negative numbers not supported. -1,-2"));
    });

    it("Numbers graders than 1000 are no valids", function () {
        expect(stringCalculator.add("2,1001")).toEqual(2);
    });

    it("Whatever delimiter long", function () {
      expect(stringCalculator.add("//;;;\n1;;;2;;;3")).toEqual(6);
    });

    // it("More than one delimiter", function () {
    //   expect(stringCalculator.add("//[#][%]\n1#2%3")).toEqual(6);
    // });

});
