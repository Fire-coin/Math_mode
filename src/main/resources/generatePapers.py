names = ["geometry", "pythagoras_theorem", "algebra", "force_delta", "velocity_delta", "limits", "differential_calculus", "force_derivative", "velocity_derivative", "calculus", "mass_energy_equivalence"]
for i in names:
    with open(f"assets/mathmode/models/item/{i}.json", 'w') as file:
        file.write(f"""{'{'}
    "parent": "item/generated",
    "textures": {'{'}
        "layer0": "mathmode:item/{i}"
    {'}'}
{'}'}""")