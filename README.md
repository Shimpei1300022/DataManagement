# ex01
static int
hitSphere(Vector3 origin, Vector3 direction, Sphere sphere, float* t)
{
    float o_dot_d;
    computeDotProduct(origin, direction, &o_dot_d);

    float d_dot_c;
    computeDotProduct(direction, sphere._center, &d_dot_c);

    float o_dot_c;
    computeDotProduct(origin, sphere._center, &o_dot_c);

    float o_dot_o;
    computeDotProduct(origin, origin, &o_dot_o);

    float c_dot_c;
    computeDotProduct(sphere._center, sphere._center, &c_dot_c);

    float r_dot_r = sphere._radius * sphere._radius;


    float od_sub_dc = o_dot_d - d_dot_c;

    *t = -od_sub_dc - sqrtf(od_sub_dc*od_sub_dc + 2*o_dot_c - o_dot_o - c_dot_c + r_dot_r);
    if (-0.001f < *t && *t < 0.001f) {
        *t = -od_sub_dc + sqrtf(od_sub_dc*od_sub_dc + 2*o_dot_c - o_dot_o - c_dot_c + r_dot_r);
    }
    if (*t > 0) return 1;

    return 0;
}
