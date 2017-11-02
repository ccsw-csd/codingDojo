class StringCalculator {
    constructor(){
        String.prototype.replaceAll = function(search, replacement) {
            var target = this;
            return target.replace(new RegExp(search, 'g'), replacement);
        };

        this.comaSeparator = ",";
        this.newDelimiterPrefix = "//";
        this.newDelimiterEnd = "\n";
        this.newDelimitationPosition = 2;
        this.separators = ["\n"];
        
        this.REGEX_ALL_BETWEEN_DELIMITERS = "[^\/\/]+(?=\\n)";
        this.ALL_AFTER_END_DELIMITER = "\\n.[^\n]*";
        this.ALL_BETWEEN_BRACKETS = "/[^\[]+(?=\])/g";
    }

    add(input){
        if(input.length === 0)
            return 0;

        var numbers = this.extractNumbers(input);

        return this.sumStringNumbers(numbers);
    }

    extractNumbers(input) {
        return this.unifySeparators(input).split(this.comaSeparator);
    }

    sumStringNumbers(numbers) {
        var result = [];
        var negativeNumbers = [];

        negativeNumbers = numbers.filter(num => num < 0);

        if(negativeNumbers.length > 0){
            throw new Error("Negative numbers not supported. " + negativeNumbers);
        }

        result = numbers.filter(num => num <= 1000);

        return result.reduce((a, b) => parseInt(a) + parseInt(b), 0);
    }

    unifySeparators(input) {
        var result = input;
        var separatorsToCheck = [];

        if(input.startsWith(this.newDelimiterPrefix)) {
            separatorsToCheck = input.match(this.REGEX_ALL_BETWEEN_DELIMITERS);
            if(separatorsToCheck.length === 1 && separatorsToCheck[0].startsWith("[")){
                result = separatorsToCheck[0]
                separatorsToCheck = input.match(this.ALL_BETWEEN_BRACKETS);
            }
            result = input.match(this.ALL_AFTER_END_DELIMITER)[0].substring(1);
        }

        separatorsToCheck = separatorsToCheck.concat(this.separators);

        separatorsToCheck.forEach(separator => {
            result = result.replaceAll(separator, this.comaSeparator);
        });

        return result;
    }
}
