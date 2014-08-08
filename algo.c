#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SZ 32

struct Item {
	unsigned int value;
	float weight;
};

static char *binrep (unsigned int val, char *buff, int sz)
{
	char *pbuff = buff;

	if (sz < 1) return NULL;

	if (val == 0) {
		*pbuff++ = '0';
		*pbuff = '\0';
		return buff;
	}

	pbuff += sz;
	*pbuff-- = '\0';

	while (val != 0) {
		if (sz-- == 0) return NULL;
		*pbuff-- = ((val & 1) == 1) ? '1' : '0';

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
	char *endBinaryCode = malloc(sizeof(char)*(SZ+1));
	int max = init(((argc-1)/2));
	struct Item items[(argc-1)/2];

	if ((argc-1) % 2 == 0 && argc != 1) {
		for (i = 1, j = 2, k = 0; i < argc; i+=2, j+=2, k++) {
			/* atoi and atof doesn't return Error! */
			items[k].value = atoi(argv[i]);
			items[k].weight = atof(argv[j]);
		}
	} else {
		fprintf(stderr, "Please specify correct values\n");
	}

	for (i = 1; i <= max; i++) {
		currentValue = 0;
		currentWeight = 0.0;
		const char *tmp = binrep(i, buff, SZ);
		if (tmp == NULL) {
			fprintf(stderr, "Not enought space in! See: 93\n");
		}

		/* strnlen(char *, size_t) would be better... */
		int size =(int) strlen(tmp);

		for (j = size; j >= 0; j--) {
			if (tmp[j] == '1') {
				currentValue += items[j].value;
				currentWeight += items[j].weight;
			}
		}

		if (currentWeight <= maxWeight) {
			maxValue = currentValue;
			endWeight = currentWeight;
			memcpy(endBinaryCode, tmp, (SZ+1)*sizeof(char));
		}
	}

	printf("MaxValue: %d\n", maxValue);
	printf("MaxWeight: %f\n", endWeight);
	printf("Endbinarycode: %s\n", endBinaryCode);
	free(endBinaryCode);

	return 0;
}
