### 깊이 우선 탐색(Depth-first search)

- 그래프 완전 탐색 기법 중 하나
- 그래프 시작노드에서 출발하여 탐색할 한 쪽 분기를 정하여 최대 깊이까지 탐색을 마친 후 다른 쪽 분기로 이동하여 다시 탐색을 수행하는 알고리즘
- 재귀함수나 스택 자료구조를 이용하여 구현
- 시간복잡도: O(V+E), V:노드 수, E:엣지 수


- 데이터를 담는 자료구조로 인접리스트를 쓴다. 노드 방문 여부를 체크할 배열도 필요(한번 방문한 곳을 다시 방문하면 안되므로)

- [인접행렬로 표현](https://blog.hexabrain.net/268)