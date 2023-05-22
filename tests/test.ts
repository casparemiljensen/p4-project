function main (workbook: ExcelScript.Workbook) {
    function main() {
    }

    main()
}
function SUM(numbers: unknown[]): number {
    return numbers.reduce((accumulator, currentValue) => accumulator + currentValue, 0);
}

function AVERAGE(numbers: unknown[]): number {
    if (numbers.length === 0) {
        throw new Error('Cannot calculate average of an empty array');
    }

    const sum = numbers.reduce((accumulator, currentValue) => accumulator + currentValue, 0);
    return sum / numbers.length;
}