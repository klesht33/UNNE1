import os
import matplotlib.pyplot as plt
import matplotlib.patches as patches

out_dir = '/home/gabriel/Documentos/UNNE/UNNE1/Sistemas Operativos/Cursada/TPS/graficos_tp3'
os.makedirs(out_dir, exist_ok=True)

plt.rcParams['font.sans-serif'] = 'DejaVu Sans'
plt.rcParams['font.family'] = 'sans-serif'
plt.rcParams['figure.dpi'] = 300

# ==============================================================================
# 1. GRAFICO EJERCICIO 1: Encadenamiento de bloques (Grilla 4x6)
# ==============================================================================
def generate_graphic_ej1_grid():
    fig, ax = plt.subplots(figsize=(11, 7.5))
    ax.set_xlim(-0.5, 6.5)
    ax.set_ylim(-1.2, 5.3)
    ax.axis('off')

    colors = {
        'A': '#FF6B6B',  # Coral Red
        'B': '#4D96FF',  # Sky Blue
        'C': '#6BCB77',  # Mint Green
        'D': '#FFD93D',  # Amber
        'E': '#FF9F45',  # Pastel Orange
        'Libre': '#E2E8F0' # Light Slate Gray
    }

    grid_data = [
        [('B00', 'A(1)', 'A'), ('B01', 'C(3)', 'C'), ('B02', 'B(2)', 'B'), ('B03', 'D(1)', 'D'), ('B04', 'B(3)', 'B'), ('B05', 'B(4)', 'B')],
        [('B06', 'E(1)', 'E'), ('B07', 'A(4)', 'A'), ('B08', 'C(4)', 'C'), ('B09', 'D(2)', 'D'), ('B10', 'Libre', 'Libre'), ('B11', 'C(6)', 'C')],
        [('B12', 'A(2)', 'A'), ('B13', 'D(3)', 'D'), ('B14', 'D(5)', 'D'), ('B15', 'Libre', 'Libre'), ('B16', 'C(5)', 'C'), ('B17', 'C(2)', 'C')],
        [('B18', 'A(3)', 'A'), ('B19', 'D(4)', 'D'), ('B20', 'Libre', 'Libre'), ('B21', 'B(1)', 'B'), ('B22', 'Libre', 'Libre'), ('B23', 'C(1)', 'C')]
    ]

    ax.text(3.15, 5.0, "EJERCICIO 1: Asignación por Encadenamiento de Bloques", 
            ha='center', va='center', fontsize=15, fontweight='bold', color='#1E293B')
    ax.text(3.15, 4.65, "Memoria secundaria de 24 bloques (B00 - B23) | Grilla de 4 × 6", 
            ha='center', va='center', fontsize=11, color='#475569')

    for r_idx, row in enumerate(grid_data):
        y = 3.6 - r_idx * 1.05
        for c_idx, (b_id, label, cat) in enumerate(row):
            x = c_idx * 1.05 + 0.15
            color = colors[cat]
            rect = patches.FancyBboxPatch((x, y), 0.95, 0.9, boxstyle="round,pad=0.03,rounding_size=0.1",
                                          facecolor=color, edgecolor='#334155', linewidth=1.5)
            ax.add_patch(rect)
            
            ax.text(x + 0.475, y + 0.63, b_id, ha='center', va='center', fontsize=10, fontweight='bold', color='#0F172A')
            ax.text(x + 0.475, y + 0.28, label, ha='center', va='center', fontsize=12, fontweight='heavy', 
                    color='#0F172A' if cat != 'Libre' else '#64748B')

    legend_y = -0.15
    items = [
        ('Archivo A (4 blk): B00→B12→B18→B07', 'A'),
        ('Archivo B (4 blk): B21→B02→B04→B05', 'B'),
        ('Archivo C (6 blk): B23→B17→B01→B08→B16→B11', 'C'),
        ('Archivo D (5 blk): B03→B09→B13→B19→B14', 'D'),
        ('Archivo E (1 blk): B06', 'E'),
        ('Bloques Libres (4 blk): B10, B15, B20, B22', 'Libre')
    ]

    for i, (txt, cat) in enumerate(items):
        col_pos = i % 2
        row_pos = i // 2
        lx = 0.2 + col_pos * 3.3
        ly = legend_y - row_pos * 0.35
        rect = patches.FancyBboxPatch((lx, ly - 0.08), 0.28, 0.22, boxstyle="round,pad=0.02,rounding_size=0.05",
                                      facecolor=colors[cat], edgecolor='#334155', linewidth=1)
        ax.add_patch(rect)
        ax.text(lx + 0.38, ly + 0.03, txt, ha='left', va='center', fontsize=9.5, fontweight='bold', color='#1E293B')

    plt.tight_layout()
    plt.savefig(f'{out_dir}/grafico_ej1_encadenamiento.png', bbox_inches='tight', dpi=300)
    plt.close()
    print("1/6: grafico_ej1_encadenamiento.png OK")

# ==============================================================================
# 2. GRAFICO EJERCICIO 1: Esquema de Flujo Tabla FAT
# ==============================================================================
def generate_graphic_ej1_fat_flow():
    fig, ax = plt.subplots(figsize=(12, 6.5))
    ax.set_xlim(0, 12)
    ax.set_ylim(0, 7)
    ax.axis('off')

    ax.text(6, 6.6, "EJERCICIO 1: Cadenas de Asignación en Tabla FAT", 
            ha='center', va='center', fontsize=14, fontweight='bold', color='#1E293B')
    ax.text(6, 6.2, "Visualización de las listas enlazadas que conforman cada archivo", 
            ha='center', va='center', fontsize=10.5, color='#475569')

    files = [
        ("Archivo A", ['00', '12', '18', '07', 'EOF'], '#FF6B6B', 5.2),
        ("Archivo B", ['21', '02', '04', '05', 'EOF'], '#4D96FF', 4.1),
        ("Archivo C", ['23', '17', '01', '08', '16', '11', 'EOF'], '#6BCB77', 3.0),
        ("Archivo D", ['03', '09', '13', '19', '14', 'EOF'], '#FFD93D', 1.9),
        ("Archivo E", ['06', 'EOF'], '#FF9F45', 0.8),
    ]

    for fname, nodes, col, y in files:
        # File title badge
        badge = patches.FancyBboxPatch((0.2, y - 0.25), 1.6, 0.5, boxstyle="round,pad=0.03,rounding_size=0.1",
                                       facecolor=col, edgecolor='#334155', linewidth=1.5)
        ax.add_patch(badge)
        ax.text(1.0, y, fname, ha='center', va='center', fontsize=10.5, fontweight='bold', color='#0F172A')

        # Nodes
        curr_x = 2.4
        step = 1.3
        for idx, node in enumerate(nodes):
            is_eof = (node == 'EOF')
            node_col = '#CBD5E1' if is_eof else '#FFFFFF'
            box = patches.FancyBboxPatch((curr_x, y - 0.25), 0.8, 0.5, boxstyle="round,pad=0.03,rounding_size=0.08",
                                         facecolor=node_col, edgecolor='#334155', linewidth=1.2)
            ax.add_patch(box)
            ax.text(curr_x + 0.4, y, f"B{node}" if not is_eof else "EOF", 
                    ha='center', va='center', fontsize=10, fontweight='bold', 
                    color='#DC2626' if is_eof else '#0F172A')

            if idx < len(nodes) - 1:
                ax.annotate('', xy=(curr_x + 1.25, y), xytext=(curr_x + 0.85, y),
                            arrowprops=dict(facecolor='#334155', edgecolor='#334155', width=1.8, headwidth=6, headlength=6))
            curr_x += step

    plt.tight_layout()
    plt.savefig(f'{out_dir}/grafico_ej1_fat_flow.png', bbox_inches='tight', dpi=300)
    plt.close()
    print("2/6: grafico_ej1_fat_flow.png OK")

# ==============================================================================
# 3. GRAFICO SEGUNDO ESQUEMA (Z, V, S, H, U) - Grilla 3x8
# ==============================================================================
def generate_graphic_ej2_grid():
    fig, ax = plt.subplots(figsize=(13, 6.2))
    ax.set_xlim(-0.5, 8.5)
    ax.set_ylim(-1.2, 4.5)
    ax.axis('off')

    colors = {
        'Z': '#C084FC',  # Soft Violet
        'V': '#38BDF8',  # Cyan Sky
        'S': '#FB923C',  # Orange
        'H': '#F43F5E',  # Rose
        'U': '#34D399',  # Emerald
        'Libre': '#E2E8F0' # Gray
    }

    grid_data = [
        [('B00', 'Z(5)', 'Z'), ('B01', 'V(3)', 'V'), ('B02', 'Z(4)', 'Z'), ('B03', 'S(1)', 'S'),
         ('B04', 'H(2)', 'H'), ('B05', 'Z(3)', 'Z'), ('B06', 'V(1)', 'V'), ('B07', 'H(1)', 'H')],
        [('B08', 'V(2)', 'V'), ('B09', 'Z(1)', 'Z'), ('B10', 'Libre', 'Libre'), ('B11', 'V(5)', 'V'),
         ('B12', 'U(1)', 'U'), ('B13', 'Z(2)', 'Z'), ('B14', 'H(4)', 'H'), ('B15', 'Libre', 'Libre')],
        [('B16', 'S(2)', 'S'), ('B17', 'V(4)', 'V'), ('B18', 'H(3)', 'H'), ('B19', 'U(2)', 'U'),
         ('B20', 'V(6)', 'V'), ('B21', 'Libre', 'Libre'), ('B22', 'H(5)', 'H'), ('B23', 'U(3)', 'U')]
    ]

    ax.text(4.0, 4.2, "EJERCICIO 4: Encadenamiento de Bloques (Archivos Z, V, S, H, U)", 
            ha='center', va='center', fontsize=14, fontweight='bold', color='#1E293B')
    ax.text(4.0, 3.85, "Memoria secundaria de 24 bloques (B00 - B23) | Grilla de 3 × 8", 
            ha='center', va='center', fontsize=10.5, color='#475569')

    for r_idx, row in enumerate(grid_data):
        y = 2.8 - r_idx * 1.05
        for c_idx, (b_id, label, cat) in enumerate(row):
            x = c_idx * 1.05 + 0.15
            color = colors[cat]
            rect = patches.FancyBboxPatch((x, y), 0.95, 0.9, boxstyle="round,pad=0.03,rounding_size=0.1",
                                          facecolor=color, edgecolor='#334155', linewidth=1.5)
            ax.add_patch(rect)
            
            ax.text(x + 0.475, y + 0.63, b_id, ha='center', va='center', fontsize=9.5, fontweight='bold', color='#0F172A')
            ax.text(x + 0.475, y + 0.28, label, ha='center', va='center', fontsize=11, fontweight='heavy', 
                    color='#0F172A' if cat != 'Libre' else '#64748B')

    legend_y = -0.15
    items = [
        ('Archivo Z (5 blk): B09→B13→B05→B02→B00', 'Z'),
        ('Archivo V (6 blk): B06→B08→B01→B17→B11→B20', 'V'),
        ('Archivo S (2 blk): B03→B16', 'S'),
        ('Archivo H (5 blk): B07→B04→B18→B14→B22', 'H'),
        ('Archivo U (3 blk): B12→B19→B23', 'U'),
        ('Bloques Libres (3 blk): B10, B15, B21', 'Libre')
    ]

    for i, (txt, cat) in enumerate(items):
        col_pos = i % 2
        row_pos = i // 2
        lx = 0.5 + col_pos * 4.2
        ly = legend_y - row_pos * 0.35
        rect = patches.FancyBboxPatch((lx, ly - 0.08), 0.28, 0.22, boxstyle="round,pad=0.02,rounding_size=0.05",
                                      facecolor=colors[cat], edgecolor='#334155', linewidth=1)
        ax.add_patch(rect)
        ax.text(lx + 0.38, ly + 0.03, txt, ha='left', va='center', fontsize=9.5, fontweight='bold', color='#1E293B')

    plt.tight_layout()
    plt.savefig(f'{out_dir}/grafico_ej2_encadenamiento.png', bbox_inches='tight', dpi=300)
    plt.close()
    print("3/6: grafico_ej2_encadenamiento.png OK")

# ==============================================================================
# 4. GRAFICO EJERCICIOS 5 Y 6: Jerarquía del Sistema de Archivos y Rutas
# ==============================================================================
def generate_graphic_rutas():
    fig, ax = plt.subplots(figsize=(12, 7.5))
    ax.set_xlim(0, 12)
    ax.set_ylim(0, 8)
    ax.axis('off')

    ax.text(6, 7.6, "EJERCICIOS 5 Y 6: Jerarquía del Sistema de Archivos y Resolución de Rutas", 
            ha='center', va='center', fontsize=13.5, fontweight='bold', color='#1E293B')
    ax.text(6, 7.25, "Rutas absolutas (desde '/') y relativas (mediante '../' para ascender al directorio padre)", 
            ha='center', va='center', fontsize=10, color='#475569')

    # Root
    root_box = patches.FancyBboxPatch((5.5, 6.3), 1.0, 0.5, boxstyle="round,pad=0.03,rounding_size=0.08",
                                      facecolor='#1E293B', edgecolor='#0F172A', linewidth=1.5)
    ax.add_patch(root_box)
    ax.text(6.0, 6.55, "/ (raíz)", ha='center', va='center', fontsize=11, fontweight='bold', color='#FFFFFF')

    # Level 1 directories
    l1_dirs = [
        ("home", 1.8, 5.0),
        ("proyectos", 4.2, 5.0),
        ("etc", 6.2, 5.0),
        ("srv", 8.2, 5.0),
        ("web", 10.0, 5.0),
        ("bin", 11.2, 5.0)
    ]

    for name, x, y in l1_dirs:
        box = patches.FancyBboxPatch((x - 0.6, y - 0.2), 1.2, 0.45, boxstyle="round,pad=0.03,rounding_size=0.08",
                                     facecolor='#3B82F6', edgecolor='#1D4ED8', linewidth=1.2)
        ax.add_patch(box)
        ax.text(x, y + 0.02, name + "/", ha='center', va='center', fontsize=10, fontweight='bold', color='#FFFFFF')
        ax.plot([6.0, x], [6.3, y + 0.25], color='#94A3B8', linewidth=1.5, zorder=0)

    # Subtrees:
    # 1. home -> pedro/musica/cancion.mp3 & ana/descargas/imagen.png
    # pedro & ana
    ax.plot([1.8, 1.0], [4.8, 3.9], color='#94A3B8', linewidth=1.2)
    ax.plot([1.8, 2.4], [4.8, 3.9], color='#94A3B8', linewidth=1.2)

    p_box = patches.FancyBboxPatch((0.5, 3.6), 1.0, 0.38, boxstyle="round,pad=0.02,rounding_size=0.06",
                                   facecolor='#60A5FA', edgecolor='#2563EB', linewidth=1)
    ax.add_patch(p_box)
    ax.text(1.0, 3.79, "pedro/", ha='center', va='center', fontsize=9, fontweight='bold', color='#FFFFFF')

    a_box = patches.FancyBboxPatch((2.0, 3.6), 1.0, 0.38, boxstyle="round,pad=0.02,rounding_size=0.06",
                                   facecolor='#60A5FA', edgecolor='#2563EB', linewidth=1)
    ax.add_patch(a_box)
    ax.text(2.5, 3.79, "ana/", ha='center', va='center', fontsize=9, fontweight='bold', color='#FFFFFF')

    # musica & descargas
    ax.plot([1.0, 1.0], [3.6, 2.8], color='#94A3B8', linewidth=1.2)
    ax.plot([2.5, 2.5], [3.6, 2.8], color='#94A3B8', linewidth=1.2)

    m_box = patches.FancyBboxPatch((0.45, 2.5), 1.1, 0.35, boxstyle="round,pad=0.02,rounding_size=0.06",
                                   facecolor='#93C5FD', edgecolor='#3B82F6', linewidth=1)
    ax.add_patch(m_box)
    ax.text(1.0, 2.67, "musica/", ha='center', va='center', fontsize=8.5, fontweight='bold', color='#1E293B')

    d_box = patches.FancyBboxPatch((1.9, 2.5), 1.2, 0.35, boxstyle="round,pad=0.02,rounding_size=0.06",
                                   facecolor='#93C5FD', edgecolor='#3B82F6', linewidth=1)
    ax.add_patch(d_box)
    ax.text(2.5, 2.67, "descargas/", ha='center', va='center', fontsize=8.5, fontweight='bold', color='#1E293B')

    # files cancion.mp3 & imagen.png
    ax.plot([1.0, 1.0], [2.5, 1.7], color='#94A3B8', linewidth=1.2)
    ax.plot([2.5, 2.5], [2.5, 1.7], color='#94A3B8', linewidth=1.2)

    f1_box = patches.FancyBboxPatch((0.2, 1.3), 1.6, 0.4, boxstyle="round,pad=0.02,rounding_size=0.06",
                                    facecolor='#FEF08A', edgecolor='#CA8A04', linewidth=1.2)
    ax.add_patch(f1_box)
    ax.text(1.0, 1.5, "cancion.mp3", ha='center', va='center', fontsize=8.5, fontweight='bold', color='#854D0E')

    f2_box = patches.FancyBboxPatch((1.8, 1.3), 1.4, 0.4, boxstyle="round,pad=0.02,rounding_size=0.06",
                                    facecolor='#FEF08A', edgecolor='#CA8A04', linewidth=1.2)
    ax.add_patch(f2_box)
    ax.text(2.5, 1.5, "imagen.png", ha='center', va='center', fontsize=8.5, fontweight='bold', color='#854D0E')

    # proyectos -> notas.txt
    ax.plot([4.2, 4.2], [4.8, 3.8], color='#94A3B8', linewidth=1.2)
    f3_box = patches.FancyBboxPatch((3.5, 3.4), 1.4, 0.4, boxstyle="round,pad=0.02,rounding_size=0.06",
                                    facecolor='#FEF08A', edgecolor='#CA8A04', linewidth=1.2)
    ax.add_patch(f3_box)
    ax.text(4.2, 3.6, "notas.txt", ha='center', va='center', fontsize=8.5, fontweight='bold', color='#854D0E')

    # etc -> config -> red.conf
    ax.plot([6.2, 6.2], [4.8, 3.8], color='#94A3B8', linewidth=1.2)
    cfg_box = patches.FancyBboxPatch((5.6, 3.5), 1.2, 0.35, boxstyle="round,pad=0.02,rounding_size=0.06",
                                     facecolor='#93C5FD', edgecolor='#3B82F6', linewidth=1)
    ax.add_patch(cfg_box)
    ax.text(6.2, 3.67, "config/", ha='center', va='center', fontsize=8.5, fontweight='bold', color='#1E293B')

    ax.plot([6.2, 6.2], [3.5, 2.6], color='#94A3B8', linewidth=1.2)
    f4_box = patches.FancyBboxPatch((5.5, 2.2), 1.4, 0.4, boxstyle="round,pad=0.02,rounding_size=0.06",
                                    facecolor='#FEF08A', edgecolor='#CA8A04', linewidth=1.2)
    ax.add_patch(f4_box)
    ax.text(6.2, 2.4, "red.conf", ha='center', va='center', fontsize=8.5, fontweight='bold', color='#854D0E')

    # srv -> diego/scripts/deploy.sh & laura/backups/respaldo_2025.zip
    ax.plot([8.2, 7.6], [4.8, 3.9], color='#94A3B8', linewidth=1.2)
    ax.plot([8.2, 8.8], [4.8, 3.9], color='#94A3B8', linewidth=1.2)

    diego_box = patches.FancyBboxPatch((7.1, 3.6), 1.0, 0.38, boxstyle="round,pad=0.02,rounding_size=0.06",
                                       facecolor='#60A5FA', edgecolor='#2563EB', linewidth=1)
    ax.add_patch(diego_box)
    ax.text(7.6, 3.79, "diego/", ha='center', va='center', fontsize=8.5, fontweight='bold', color='#FFFFFF')

    laura_box = patches.FancyBboxPatch((8.3, 3.6), 1.0, 0.38, boxstyle="round,pad=0.02,rounding_size=0.06",
                                       facecolor='#60A5FA', edgecolor='#2563EB', linewidth=1)
    ax.add_patch(laura_box)
    ax.text(8.8, 3.79, "laura/", ha='center', va='center', fontsize=8.5, fontweight='bold', color='#FFFFFF')

    # scripts & backups
    ax.plot([7.6, 7.6], [3.6, 2.8], color='#94A3B8', linewidth=1.2)
    ax.plot([8.8, 8.8], [3.6, 2.8], color='#94A3B8', linewidth=1.2)

    scr_box = patches.FancyBboxPatch((7.05, 2.5), 1.1, 0.35, boxstyle="round,pad=0.02,rounding_size=0.06",
                                     facecolor='#93C5FD', edgecolor='#3B82F6', linewidth=1)
    ax.add_patch(scr_box)
    ax.text(7.6, 2.67, "scripts/", ha='center', va='center', fontsize=8.5, fontweight='bold', color='#1E293B')

    bck_box = patches.FancyBboxPatch((8.25, 2.5), 1.1, 0.35, boxstyle="round,pad=0.02,rounding_size=0.06",
                                     facecolor='#93C5FD', edgecolor='#3B82F6', linewidth=1)
    ax.add_patch(bck_box)
    ax.text(8.8, 2.67, "backups/", ha='center', va='center', fontsize=8.5, fontweight='bold', color='#1E293B')

    # deploy.sh & respaldo_2025.zip
    ax.plot([7.6, 7.6], [2.5, 1.7], color='#94A3B8', linewidth=1.2)
    ax.plot([8.8, 8.8], [2.5, 1.7], color='#94A3B8', linewidth=1.2)

    f5_box = patches.FancyBboxPatch((7.0, 1.3), 1.2, 0.4, boxstyle="round,pad=0.02,rounding_size=0.06",
                                    facecolor='#FEF08A', edgecolor='#CA8A04', linewidth=1.2)
    ax.add_patch(f5_box)
    ax.text(7.6, 1.5, "deploy.sh", ha='center', va='center', fontsize=8.5, fontweight='bold', color='#854D0E')

    f6_box = patches.FancyBboxPatch((8.0, 1.3), 1.6, 0.4, boxstyle="round,pad=0.02,rounding_size=0.06",
                                    facecolor='#FEF08A', edgecolor='#CA8A04', linewidth=1.2)
    ax.add_patch(f6_box)
    ax.text(8.8, 1.5, "respaldo_2025.zip", ha='center', va='center', fontsize=8, fontweight='bold', color='#854D0E')

    # web -> estilo.css
    ax.plot([10.0, 10.0], [4.8, 3.8], color='#94A3B8', linewidth=1.2)
    f7_box = patches.FancyBboxPatch((9.3, 3.4), 1.4, 0.4, boxstyle="round,pad=0.02,rounding_size=0.06",
                                    facecolor='#FEF08A', edgecolor='#CA8A04', linewidth=1.2)
    ax.add_patch(f7_box)
    ax.text(10.0, 3.6, "estilo.css", ha='center', va='center', fontsize=8.5, fontweight='bold', color='#854D0E')

    # bin -> utilidades -> compresor
    ax.plot([11.2, 11.2], [4.8, 3.8], color='#94A3B8', linewidth=1.2)
    ut_box = patches.FancyBboxPatch((10.6, 3.5), 1.2, 0.35, boxstyle="round,pad=0.02,rounding_size=0.06",
                                    facecolor='#93C5FD', edgecolor='#3B82F6', linewidth=1)
    ax.add_patch(ut_box)
    ax.text(11.2, 3.67, "utilidades/", ha='center', va='center', fontsize=8, fontweight='bold', color='#1E293B')

    ax.plot([11.2, 11.2], [3.5, 2.6], color='#94A3B8', linewidth=1.2)
    f8_box = patches.FancyBboxPatch((10.5, 2.2), 1.4, 0.4, boxstyle="round,pad=0.02,rounding_size=0.06",
                                    facecolor='#FEF08A', edgecolor='#CA8A04', linewidth=1.2)
    ax.add_patch(f8_box)
    ax.text(11.2, 2.4, "compresor", ha='center', va='center', fontsize=8.5, fontweight='bold', color='#854D0E')

    # Summary box at bottom
    sum_box = patches.FancyBboxPatch((0.2, 0.1), 11.6, 0.9, boxstyle="round,pad=0.02,rounding_size=0.08",
                                     facecolor='#F8FAFC', edgecolor='#CBD5E1', linewidth=1.2)
    ax.add_patch(sum_box)
    ax.text(6.0, 0.65, "Rutas Relativas Destacadas:", ha='center', va='center', fontsize=9.5, fontweight='bold', color='#1E293B')
    ax.text(6.0, 0.35, "Desde 'proyectos/' hacia 'red.conf': ../../etc/config/red.conf  |  Hacia 'compresor': ../../bin/utilidades/compresor",
            ha='center', va='center', fontsize=9, color='#475569')

    plt.tight_layout()
    plt.savefig(f'{out_dir}/grafico_ej5_6_rutas.png', bbox_inches='tight', dpi=300)
    plt.close()
    print("4/6: grafico_ej5_6_rutas.png OK")

# ==============================================================================
# 5. GRAFICO EJERCICIO 7: Asignación Contigua y Fragmentación Externa
# ==============================================================================
def generate_graphic_ej7_contigua():
    fig, ax = plt.subplots(figsize=(13, 6.0))
    ax.set_xlim(-0.5, 24.5)
    ax.set_ylim(-0.8, 4.5)
    ax.axis('off')

    ax.text(12, 4.1, "EJERCICIO 7: Asignación Contigua y Fragmentación Externa", 
            ha='center', va='center', fontsize=14, fontweight='bold', color='#1E293B')
    ax.text(12, 3.65, "Asignación contigua para procesos/archivos P1 (4 bloques) y P2 (5 bloques)", 
            ha='center', va='center', fontsize=10.5, color='#475569')

    # Let's draw the disk blocks 0 to 23
    # B16 to B19 are contiguous free assigned to P1
    # Other free blocks are scattered (e.g. B10, B15, B21, etc.)
    # Let's label each block
    block_status = ['Ocupado'] * 24
    # Free blocks in this disk setup: 10, 15, 16, 17, 18, 19, 21 (total 7 free, or 16-19 free + 2 others = 6 total free)
    # The note says: "el unico hueco libre es de los bloques B16 a B19, son justo 4 libres"
    # And "P2 necesita 5 bloques libres en estado contiguo... no hay ningun hueco libre contiguo de 5 bloques, aunque el disco tenga 6 bloques libres en total."
    # So 6 free blocks in total: B16, B17, B18, B19 (4 contiguous) + 2 scattered (e.g., B10, B21)
    free_scattered = [10, 21]
    p1_blocks = [16, 17, 18, 19]

    y_disk = 2.0
    for b in range(24):
        x = b
        if b in p1_blocks:
            col = '#38BDF8' # Sky blue for P1
            lbl = f"P1\n(B{b})"
            text_col = '#0369A1'
        elif b in free_scattered:
            col = '#E2E8F0' # Gray for free
            lbl = f"Libre\n(B{b})"
            text_col = '#64748B'
        else:
            col = '#CBD5E1' # Gray occupied
            lbl = f"Ocup.\n(B{b})"
            text_col = '#475569'

        rect = patches.FancyBboxPatch((x + 0.05, y_disk), 0.9, 1.1, boxstyle="round,pad=0.02,rounding_size=0.06",
                                      facecolor=col, edgecolor='#334155', linewidth=1.2)
        ax.add_patch(rect)
        ax.text(x + 0.5, y_disk + 0.55, lbl, ha='center', va='center', fontsize=7.5, fontweight='bold', color=text_col)

    # Bracket for P1
    ax.annotate('Hueco contiguo de 4 bloques asignado a P1', 
                xy=(18.0, 1.85), xytext=(18.0, 1.1),
                arrowprops=dict(facecolor='#0284C7', edgecolor='#0284C7', width=1.5, headwidth=6),
                ha='center', va='top', fontsize=9.5, fontweight='bold', color='#0284C7')

    # Warning box for P2 (Fragmentacion Externa)
    warn_box = patches.FancyBboxPatch((1.0, -0.6), 22.0, 1.3, boxstyle="round,pad=0.03,rounding_size=0.1",
                                      facecolor='#FEF2F2', edgecolor='#EF4444', linewidth=1.5)
    ax.add_patch(warn_box)
    ax.text(12.0, 0.35, "⚠️ CASO P2: NO ES POSIBLE ASIGNAR POR FRAGMENTACIÓN EXTERNA", 
            ha='center', va='center', fontsize=11, fontweight='bold', color='#B91C1C')
    ax.text(12.0, -0.05, 
            "P2 requiere 5 bloques continuos. Aunque el almacenamiento dispone de 6 bloques libres en total (B16, B17, B18, B19, B10, B21),\n"
            "no existe ningún bloque continuo de tamaño ≥ 5. Los bloques libres están dispersos en huecos no contiguos.",
            ha='center', va='center', fontsize=9, color='#7F1D1D')

    plt.tight_layout()
    plt.savefig(f'{out_dir}/grafico_ej7_asignacion_contigua.png', bbox_inches='tight', dpi=300)
    plt.close()
    print("5/6: grafico_ej7_asignacion_contigua.png OK")

# ==============================================================================
# 6. GRAFICO EJERCICIO 8: Asignación Indexada con Bloques Encadenados
# ==============================================================================
def generate_graphic_ej8_indexada():
    fig, ax = plt.subplots(figsize=(13, 7.5))
    ax.set_xlim(0, 13)
    ax.set_ylim(-0.5, 7.5)
    ax.axis('off')

    ax.text(6.5, 7.1, "EJERCICIO 8: Asignación Indexada (Máximo 3 Entradas por Bloque Índice)", 
            ha='center', va='center', fontsize=13.5, fontweight='bold', color='#1E293B')
    ax.text(6.5, 6.7, "Esquema multinivel / encadenado de bloques índices para archivos J1, J2 y J3", 
            ha='center', va='center', fontsize=10, color='#475569')

    # 1. Archivo J1
    # Needs 3 data blocks: B15, B14, B09 -> 1 index block: B01
    y1 = 5.3
    b_j1 = patches.FancyBboxPatch((0.5, y1 - 0.4), 2.2, 0.8, boxstyle="round,pad=0.03,rounding_size=0.08",
                                  facecolor='#E0E7FF', edgecolor='#4338CA', linewidth=1.5)
    ax.add_patch(b_j1)
    ax.text(1.6, y1 + 0.1, "Archivo J1", ha='center', va='center', fontsize=10.5, fontweight='bold', color='#312E81')
    ax.text(1.6, y1 - 0.2, "(3 bloques de datos)", ha='center', va='center', fontsize=8.5, color='#4338CA')

    # Index block B01
    idx_b01 = patches.FancyBboxPatch((3.5, y1 - 0.5), 2.4, 1.0, boxstyle="round,pad=0.03,rounding_size=0.08",
                                     facecolor='#C7D2FE', edgecolor='#3730A3', linewidth=1.5)
    ax.add_patch(idx_b01)
    ax.text(4.7, y1 + 0.25, "Bloque Índice B01", ha='center', va='center', fontsize=9.5, fontweight='bold', color='#1E1B4B')
    ax.text(4.7, y1 - 0.15, "Punteros: [ B15, B14, B09 ]", ha='center', va='center', fontsize=8.5, fontweight='bold', color='#312E81')

    ax.annotate('', xy=(3.4, y1), xytext=(2.8, y1),
                arrowprops=dict(facecolor='#4338CA', edgecolor='#4338CA', width=1.5, headwidth=5))

    # Data blocks for J1
    j1_data = ['B15', 'B14', 'B09']
    for k, d in enumerate(j1_data):
        dx = 6.6 + k * 1.4
        box = patches.FancyBboxPatch((dx, y1 - 0.35), 1.1, 0.7, boxstyle="round,pad=0.02,rounding_size=0.06",
                                     facecolor='#F1F5F9', edgecolor='#64748B', linewidth=1.2)
        ax.add_patch(box)
        ax.text(dx + 0.55, y1, f"Datos\n{d}", ha='center', va='center', fontsize=8.5, fontweight='bold', color='#1E293B')
        ax.annotate('', xy=(dx, y1), xytext=(5.95, y1),
                    arrowprops=dict(facecolor='#64748B', edgecolor='#64748B', width=1.0, headwidth=4))

    # 2. Archivo J2
    # Needs 5 data blocks: B05, B11, B00, B07, B13 -> 2 index blocks encadenados: B02 -> B04
    y2 = 3.3
    b_j2 = patches.FancyBboxPatch((0.5, y2 - 0.4), 2.2, 0.8, boxstyle="round,pad=0.03,rounding_size=0.08",
                                  facecolor='#DCFCE7', edgecolor='#15803D', linewidth=1.5)
    ax.add_patch(b_j2)
    ax.text(1.6, y2 + 0.1, "Archivo J2", ha='center', va='center', fontsize=10.5, fontweight='bold', color='#14532D')
    ax.text(1.6, y2 - 0.2, "(5 bloques de datos)", ha='center', va='center', fontsize=8.5, color='#15803D')

    # Index block B02
    idx_b02 = patches.FancyBboxPatch((3.2, y2 - 0.5), 2.5, 1.0, boxstyle="round,pad=0.03,rounding_size=0.08",
                                     facecolor='#BBF7D0', edgecolor='#166534', linewidth=1.5)
    ax.add_patch(idx_b02)
    ax.text(4.45, y2 + 0.25, "Índice 1: B02", ha='center', va='center', fontsize=9.5, fontweight='bold', color='#052E16')
    ax.text(4.45, y2 - 0.05, "[ B05, B11, B00 ]", ha='center', va='center', fontsize=8.5, fontweight='bold', color='#14532D')
    ax.text(4.45, y2 - 0.3, "Sig. Índice ➜ B04", ha='center', va='center', fontsize=8, color='#047857')

    ax.annotate('', xy=(3.15, y2), xytext=(2.8, y2),
                arrowprops=dict(facecolor='#15803D', edgecolor='#15803D', width=1.5, headwidth=5))

    # Index block B04
    idx_b04 = patches.FancyBboxPatch((6.4, y2 - 0.5), 2.4, 1.0, boxstyle="round,pad=0.03,rounding_size=0.08",
                                     facecolor='#BBF7D0', edgecolor='#166534', linewidth=1.5)
    ax.add_patch(idx_b04)
    ax.text(7.6, y2 + 0.25, "Índice 2: B04", ha='center', va='center', fontsize=9.5, fontweight='bold', color='#052E16')
    ax.text(7.6, y2 - 0.05, "[ B07, B13, (fin) ]", ha='center', va='center', fontsize=8.5, fontweight='bold', color='#14532D')
    ax.text(7.6, y2 - 0.3, "Sig. Índice ➜ EOF", ha='center', va='center', fontsize=8, color='#DC2626')

    ax.annotate('', xy=(6.35, y2), xytext=(5.75, y2),
                arrowprops=dict(facecolor='#047857', edgecolor='#047857', width=1.5, headwidth=5))

    # Data blocks for J2
    ax.text(10.8, y2 + 0.45, "Bloques de Datos J2:", ha='center', va='center', fontsize=9, fontweight='bold', color='#14532D')
    j2_data = ['B05', 'B11', 'B00', 'B07', 'B13']
    for k, d in enumerate(j2_data):
        dx = 9.4 + (k % 3) * 1.15
        dy = y2 - 0.05 - (k // 3) * 0.65
        box = patches.FancyBboxPatch((dx, dy - 0.25), 1.0, 0.5, boxstyle="round,pad=0.02,rounding_size=0.06",
                                     facecolor='#F1F5F9', edgecolor='#64748B', linewidth=1.2)
        ax.add_patch(box)
        ax.text(dx + 0.5, dy, d, ha='center', va='center', fontsize=8.5, fontweight='bold', color='#1E293B')

    # 3. Archivo J3
    y3 = 1.3
    b_j3 = patches.FancyBboxPatch((0.5, y3 - 0.4), 2.2, 0.8, boxstyle="round,pad=0.03,rounding_size=0.08",
                                  facecolor='#FEF3C7', edgecolor='#D97706', linewidth=1.5)
    ax.add_patch(b_j3)
    ax.text(1.6, y3 + 0.1, "Archivo J3", ha='center', va='center', fontsize=10.5, fontweight='bold', color='#78350F')
    ax.text(1.6, y3 - 0.2, "(2 bloques de datos)", ha='center', va='center', fontsize=8.5, color='#B45309')

    # Index block B06
    idx_b06 = patches.FancyBboxPatch((3.5, y3 - 0.5), 2.4, 1.0, boxstyle="round,pad=0.03,rounding_size=0.08",
                                     facecolor='#FDE68A', edgecolor='#B45309', linewidth=1.5)
    ax.add_patch(idx_b06)
    ax.text(4.7, y3 + 0.25, "Bloque Índice B06", ha='center', va='center', fontsize=9.5, fontweight='bold', color='#451A03')
    ax.text(4.7, y3 - 0.15, "Punteros: [ B03, B10 ]", ha='center', va='center', fontsize=8.5, fontweight='bold', color='#78350F')

    ax.annotate('', xy=(3.4, y3), xytext=(2.8, y3),
                arrowprops=dict(facecolor='#D97706', edgecolor='#D97706', width=1.5, headwidth=5))

    # Data blocks for J3
    j3_data = ['B03', 'B10']
    for k, d in enumerate(j3_data):
        dx = 6.6 + k * 1.4
        box = patches.FancyBboxPatch((dx, y3 - 0.35), 1.1, 0.7, boxstyle="round,pad=0.02,rounding_size=0.06",
                                     facecolor='#F1F5F9', edgecolor='#64748B', linewidth=1.2)
        ax.add_patch(box)
        ax.text(dx + 0.55, y3, f"Datos\n{d}", ha='center', va='center', fontsize=8.5, fontweight='bold', color='#1E293B')
        ax.annotate('', xy=(dx, y3), xytext=(5.95, y3),
                    arrowprops=dict(facecolor='#64748B', edgecolor='#64748B', width=1.0, headwidth=4))

    # Bottom summary: Unallocated free blocks
    free_box = patches.FancyBboxPatch((0.5, -0.3), 12.0, 0.65, boxstyle="round,pad=0.02,rounding_size=0.08",
                                      facecolor='#F8FAFC', edgecolor='#94A3B8', linewidth=1.2)
    ax.add_patch(free_box)
    ax.text(6.5, 0.05, "Bloques libres no asignados que permanecen disponibles: B08 y B12 (Total: 2 bloques libres)", 
            ha='center', va='center', fontsize=9.5, fontweight='bold', color='#334155')

    plt.tight_layout()
    plt.savefig(f'{out_dir}/grafico_ej8_asignacion_indexada.png', bbox_inches='tight', dpi=300)
    plt.close()
    print("6/6: grafico_ej8_asignacion_indexada.png OK")

if __name__ == '__main__':
    generate_graphic_ej1_grid()
    generate_graphic_ej1_fat_flow()
    generate_graphic_ej2_grid()
    generate_graphic_rutas()
    generate_graphic_ej7_contigua()
    generate_graphic_ej8_indexada()
    print("ALL 6 GRAPHICS GENERATED SUCCESSFULLY!")
