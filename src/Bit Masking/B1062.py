import sys
input = sys.stdin.readline

N, K = map(int, input().split())
# base 알파벳('a' 'n' 't' 'i' 'c) 보다 적은 수라면 모든 단어를 읽지 못함
if K < 5 :
    print(0)
    exit(0)
# 모든 알파벳을 전부 배울 수 있다면 모든 단어를 읽을 수 있음
elif K == 26 :
    print(N)
    exit(0)

words = [input().strip() for _ in range(N)]

# 주어진 단어들의 알파벳을 마스킹 처리
word_masks = []
for w in words :
    mask = 0
    for c in w :
        mask |= (1 << ord(c) - ord('a'))
    word_masks.append(mask)

# 모든 남극언어는 "anta"로 시작하고 "tica"로 끝나므로 'a', 'n', 't', 'i', 'c'은 base
base_mask = 0
for c in ['a', 'n', 't', 'i', 'c'] :
    base_mask |= (1 << ord(c) - ord('a'))

max_readable = 0

# 완전 탐색 수행
def dfs(idx, selected_cnt, learned_mask) :
    global max_readable
    # 종료 조건: K개 만큼 배울 알파벳을 골랐다면, 주어진 단어 알파벳 마스킹과 배운 알파벳 마스킹을 비교해서 읽을 수 있는 단어를 카운팅
    if selected_cnt == K :
        readable = 0
        for word_mask in word_masks :
            if word_mask & learned_mask == word_mask :
                readable += 1
        # 갱신
        max_readable = max(max_readable, readable)
        return

    # 다음 배울 단어 탐색 (idx부터 시작)
    for next_alpha_idx in range(idx, 26) :
        # 다음 단어를 이미 배웠다면 넘어가기
        if learned_mask & (1 << next_alpha_idx) :
            continue
        # 방금 뽑은 알파벳의 다음 번호를 넘기고, 고른 숫자를 갱신하고, learned_mask에 반영
        dfs(next_alpha_idx+1, selected_cnt+1, learned_mask | (1 << next_alpha_idx))

# 기본 5개 선택 및 base_mask 적용
dfs(0, 5, base_mask)
print(max_readable)
