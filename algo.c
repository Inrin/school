#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SZ 32

struct Item {
	unsigned int value;
	float weight;
};

static char *strrev(char *str)
{
	char *p1, *p2;

	if (! str || ! *str)
		return str;
	for (p1 = str, p2 = str + strlen(str) - 1; p2 > p1; ++p1, --p2)
	{
		*p1 ^= *p2;
		*p2 ^= *p1;
		*p1 ^= *p2;
	}
	return str;
}

/* Create a string of binary digits based on the input value.
 *    Input:
 *    val:  value to convert.
 *    buff: buffer to write to must be >= sz+1 chars.
 *    sz:   size of buffer.
 *    Returns address of string or NULL if not enough space provided.
 *                            */
static char *binrep (unsigned int val, char *buff, int sz)
{
	char *pbuff = buff;

	//	 Must be able to store one character at least.
	if (sz < 1) return NULL;

	//	 Special case for zero to ensure some output.
	if (val == 0) {
		*pbuff++ = '0';
		*pbuff = '\0';
		return buff;
	}

	//	 Work from the end of the buffer back.
	pbuff += sz;
	*pbuff-- = '\0';

	//	 For each bit (going backwards) store character.
	while (val != 0) {
		if (sz-- == 0) return NULL;
		*pbuff-- = ((val & 1) == 1) ? '1' : '0';

		//		 Get next bit.
		val >>= 1;
	}
	return pbuff+1;
}

static int init(int numberOfItems) {
	int i = 0;
	char maxC[numberOfItems+1];
	for (i = 0; i < numberOfItems; i++) {
		maxC[i] = '1';
	}
	maxC[numberOfItems] = '\0';

	char *start = maxC;

	int max = 0;
	while (*start)
	{
		max <<= 1;
		if (*start++ == '1') max ^=1;
	}

	return max;
}

int main(int argc, const char **argv)
{

	int i = 0;
	int j = 0;
	int k = 0;
	float maxWeight = 15;
	unsigned int maxValue = 0;
	unsigned int currentValue = 0;
	float currentWeight = 0.0;
	float endWeight = 0.0;
	char buff[SZ+1];

	int max = init(((argc-1)/2));

	struct Item items[(argc-1)/2];

	if ((argc-1) % 2 == 0 && argc != 1) {
		for (i = 1, j = 2, k = 0; i < argc; i+=2, j+=2, k++) {
			items[k].value = atoi(argv[i]);
			items[k].weight = atof(argv[j]);
		}
	} else {
		fprintf(stderr, "Please specify correct values\n");
	}

	for (i = 1; i <= max; i++) {
		currentValue = 0;
		currentWeight = 0.0;
		char *tmp = binrep(i, buff, SZ);
//		tmp = strrev(tmp);
		int size =(int) strlen(tmp);
		printf("Binärcode: %s\n", tmp);

		for (j = size; j >= 0; j--) {
			if (tmp[j] == '1') {
				currentValue += items[j].value;
				currentWeight += items[j].weight;
			}
		}

		if (currentWeight <= maxWeight) {
			maxValue = currentValue;
			endWeight = currentWeight;
		}
	}
	printf("MaxValue: %d\n", maxValue);
	printf("MaxWeight: %f\n", endWeight);

	return 0;
}
