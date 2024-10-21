class Graph:
    def __init__(self, nodes, edges):
        self.nodes = nodes
        self.edges = edges
    
    def GetNeighbors(self, node):
        return [edge[1] for edge in self.edges if edge[0] == node]

    def FindAllSimplePaths(self, start_node, end_node, path=[]):
        path = path + [start_node]
        if start_node == end_node:
            return [path]
        paths = []
        for node in self.GetNeighbors(start_node):
            if node not in path:
                newpaths = self.FindAllSimplePaths(node, end_node, path)
                for p in newpaths:
                    paths.append(p)
        return paths

    def FindPrimePaths(self):
        prime_paths = []
        for node in self.nodes:
            for neighbor in self.GetNeighbors(node):
                simple_paths = self.FindAllSimplePaths(node, neighbor)
                for path in simple_paths:
                    # Check if the path is maximal (cannot be extended)
                    if not any(path == p[:len(path)] for p in prime_paths):
                        prime_paths.append(path)
        return prime_paths

# Example usage
nodes = [1, 2, 3, 4, 5, 6, 7]
edges = [(1, 2), (1, 7), (2, 3), (2, 4), (3, 2), (4, 5), (4, 6), (5, 6), (6, 1)]
graph = Graph(nodes, edges)
prime_paths = graph.FindPrimePaths()
print("Prime Paths:", prime_paths)
