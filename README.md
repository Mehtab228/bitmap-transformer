# bitmap-transformer

## invertColors is a function that takes the rgb value and subtracts 255 from its original value to get its negative

## convertBW is a function that takes the rgb value and depending on if its closer to 255 or 0, it converts it to the respective coloe (black or white)

## grayScale is a function that takes the rgb values, adds them up and divdes them by 3 to get their grey values. It then sets that number as the value for rgb.

### If running from intellij = Bitmap test = new Bitmap("baldy-8bit.bmp", "test5", "convertBW");

### If running from terminal run = ./gradlew run --args 'ibaldy-8bit.bmp", "test5", "convertBW'
