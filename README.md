
void computeBoundaryEdges(TriangleMesh *mesh)
{
    // Complete
    int NOT_DUPLICATE = 0;
    int DUPLICATE = 1;

    int nt = mesh->_number_triangles;
    
    int numOfEdges = 0;

    int *_v0 = (int *)malloc(sizeof(int) * (3 * nt));
    int *_v1 = (int *)malloc(sizeof(int) * (3 * nt));
    int *n   = (int *)malloc(sizeof(int) * (3 * nt));
    mesh->_edges = (Pair *)malloc(sizeof(Pair) * (3 * nt));

    int findEdge = 0;

    mesh->_number_edges = 0;

    for (int i = 0; i < nt; i++) {
        int v0_i = mesh->_triangles[i]._v0;
        int v1_i = mesh->_triangles[i]._v1;
        int v2_i = mesh->_triangles[i]._v2;

        Pair Edge[3] = {
            {v0_i, v1_i},
            {v0_i, v2_i},
            {v1_i, v2_i}
        };

        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < mesh->_number_edges + 1; k++) {

                if (_v0[k] == Edge[j]._v0 && _v1[k] == Edge[j]._v1 || 
                    _v0[k] == Edge[j]._v1 && _v1[k] == Edge[j]._v0)
                {
                    findEdge = 1;
                    n[k] = DUPLICATE;
                }
            }
            if (findEdge == 0) {
                _v0[mesh->_number_edges] = Edge[j]._v0;
                _v1[mesh->_number_edges] = Edge[j]._v1;
                n[mesh->_number_edges] = NOT_DUPLICATE;
                mesh->_number_edges++;
            }
            findEdge = 0;
        }
    }

    for (int i = 0; i < mesh->_number_edges; i++) {
        if (n[i] == NOT_DUPLICATE) {
            mesh->_edges[numOfEdges]._v0 = _v0[i];
            mesh->_edges[numOfEdges]._v1 = _v1[i];
            numOfEdges++;
        }
    }
    mesh->_number_edges = numOfEdges;
}
