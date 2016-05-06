# Read from the file file.txt and print its transposed content to stdout.

#!/bin/bash

awk -F' ' 'BEGIN{
curRow=1;
}
{
	if(curRow==1)
	{
		for(i=1;i<=NF;i++)
		{
			array[i]=$i;
		}
	}else{
		for(i=1;i<=NF;i++)
		{
			array[i]=array[i]" "$i;
		}
	}
	curRow++;
}END{
    for(i=1;i<=NF;i++)
    {
        if(i==NF){
            print array[i];
        }else{
            print array[i];
        }
    }
}' file.txt