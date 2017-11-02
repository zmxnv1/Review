#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct Node{
    int value;
    struct Node* next;
}node;
void init(node* root, int* nums, int size)
{
    node* p = root;
    for(int i = 0; i < size; i++) {
        p->value = nums[i];
        if(i != size - 1) p->next = (node*)malloc(sizeof(node));
        else break;
        p = p->next;
    }
}
void print(node* root)
{
    node* p = root;
    while(p != NULL){
        printf("%d\n", p->value);
        p = p->next;
    }
}

void delete(node* p)
{
    node* temp = p;
    p = p -> next;
    free(temp);
}

int main()
{
    node* root = (node*)malloc(sizeof(node));
    int size;
    scanf("%d", &size);
    int* nums = (int*)malloc(sizeof(node));
    for(int i = 0; i < size; i++) {
        scanf("%d", &nums[i]);
    }
    init(root, nums, size);
:    
print(root);
}
