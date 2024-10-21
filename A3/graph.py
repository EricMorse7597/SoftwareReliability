class Graph:
    def __init__(self, nodes, edges):
        self.nodes = nodes
        self.edges = edges

    # method to get neighbors
    def get_neighbors(self, node):
        return [edge[1] for edge in self.edges if edge[0] == node]

    # method to get all simple paths
    def find_all_simple_paths(self, start_node, current_path):
        current_path.append(start_node)
        all_paths = [list(current_path)]  # start with current path

        for neighbor in self.get_neighbors(start_node):
            if neighbor not in current_path:  # avoid cycles
                new_paths = self.find_all_simple_paths(neighbor, list(current_path))
                all_paths.extend(new_paths)

        return all_paths

    # method to get prime paths
    def find_prime_paths(self):
        all_simple_paths = []
      
        for node in self.nodes:
            for neighbor in self.get_neighbors(node):
                simple_paths = self.find_all_simple_paths(node, [])
                all_simple_paths.extend(simple_paths)
        
        prime_paths = []
        for path in all_simple_paths:
            is_subpath = False
            for other_path in all_simple_paths:
                if path != other_path and self.is_subpath(path, other_path):
                    is_subpath = True
                    break
            if not is_subpath:
                prime_paths.append(path)
        
        return prime_paths

    # method to check if a path is a subpath of the other
    def is_subpath(self, path1, path2):
        if len(path1) > len(path2):
            return False
        for i in range(len(path2) - len(path1) + 1):
            if path2[i:i+len(path1)] == path1:
                return True
        return False

# test
nodes = [1, 2, 3, 4, 5, 6, 7]
edges = [(1, 2), (1, 7), (2, 3), (2, 4), (3, 2), (4, 5), (4, 6), (5, 6), (6, 1)]
graph = Graph(nodes, edges)
prime_paths = graph.find_prime_paths()
print("Prime Paths:", prime_paths)
