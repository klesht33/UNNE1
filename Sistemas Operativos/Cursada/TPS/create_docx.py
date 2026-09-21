import os
import docx
from docx.shared import Inches, Pt, RGBColor
from docx.enum.text import WD_ALIGN_PARAGRAPH
from docx.enum.table import WD_TABLE_ALIGNMENT, WD_ALIGN_VERTICAL
from docx.oxml import OxmlElement, parse_xml
from docx.oxml.ns import nsdecls, qn

doc_path = '/home/gabriel/Documentos/UNNE/UNNE1/Sistemas Operativos/Cursada/TPS/[SO]TP3_Resuelto.docx'
img_dir = '/home/gabriel/Documentos/UNNE/UNNE1/Sistemas Operativos/Cursada/TPS/graficos_tp3'

doc = docx.Document()

# Page setup: Margins 2.5 cm
for section in doc.sections:
    section.top_margin = Inches(0.9)
    section.bottom_margin = Inches(0.9)
    section.left_margin = Inches(0.9)
    section.right_margin = Inches(0.9)
    # Configure header / footer
    footer = section.footer
    f_p = footer.paragraphs[0]
    f_p.alignment = WD_ALIGN_PARAGRAPH.RIGHT
    f_p.text = "Sistemas Operativos (UNNE) - TP3: Sistemas de Archivos | Roa Gabriel Alan"
    f_p.style.font.name = 'Calibri'
    f_p.style.font.size = Pt(8.5)
    f_p.style.font.color.rgb = RGBColor(120, 120, 120)

# Colors
COLOR_PRIMARY = RGBColor(27, 54, 93)     # #1B365D Navy
COLOR_SECONDARY = RGBColor(43, 84, 126)  # #2B547E Steel
COLOR_TEXT = RGBColor(30, 41, 59)        # #1E293B Dark Slate
COLOR_MUTED = RGBColor(100, 116, 139)    # #64748B Slate Muted

def set_cell_background(cell, hex_color):
    tcPr = cell._tc.get_or_add_tcPr()
    shd = parse_xml(f'<w:shd {nsdecls("w")} w:fill="{hex_color}"/>')
    tcPr.append(shd)

def set_cell_margins(cell, top=100, bottom=100, left=150, right=150):
    tcPr = cell._tc.get_or_add_tcPr()
    tcMar = parse_xml(f'<w:tcMar {nsdecls("w")}><w:top w:w="{top}" w:type="dxa"/><w:bottom w:w="{bottom}" w:type="dxa"/><w:left w:w="{left}" w:type="dxa"/><w:right w:w="{right}" w:type="dxa"/></w:tcMar>')
    tcPr.append(tcMar)

def set_cell_borders(cell, top="CCCCCC", bottom="CCCCCC", left=None, right=None):
    tcPr = cell._tc.get_or_add_tcPr()
    borders_elm = parse_xml(f'''
        <w:tcBorders {nsdecls("w")}>
            <w:top w:val="{"single" if top else "none"}" w:sz="4" w:space="0" w:color="{top or "auto"}"/>
            <w:left w:val="{"single" if left else "none"}" w:sz="4" w:space="0" w:color="{left or "auto"}"/>
            <w:bottom w:val="{"single" if bottom else "none"}" w:sz="4" w:space="0" w:color="{bottom or "auto"}"/>
            <w:right w:val="{"single" if right else "none"}" w:sz="4" w:space="0" w:color="{right or "auto"}"/>
        </w:tcBorders>
    ''')
    tcPr.append(borders_elm)

def add_header_block():
    # Student and TP metadata
    p_meta = doc.add_paragraph()
    p_meta.alignment = WD_ALIGN_PARAGRAPH.RIGHT
    r_meta = p_meta.add_run("Nombre y Apellido: Roa Gabriel Alan   |   DNI: 43346673\nCátedra: Sistemas Operativos (UNNE)   |   Año Académico: 2026")
    r_meta.font.name = 'Calibri'
    r_meta.font.size = Pt(9.5)
    r_meta.font.bold = True
    r_meta.font.color.rgb = COLOR_SECONDARY

    # Main Title
    p_title = doc.add_paragraph()
    p_title.paragraph_format.space_before = Pt(12)
    p_title.paragraph_format.space_after = Pt(4)
    p_title.alignment = WD_ALIGN_PARAGRAPH.CENTER
    r_title = p_title.add_run("TRABAJO PRÁCTICO Nº 3: SISTEMAS DE ARCHIVOS")
    r_title.font.name = 'Calibri'
    r_title.font.size = Pt(20)
    r_title.font.bold = True
    r_title.font.color.rgb = COLOR_PRIMARY

    # Subtitle
    p_sub = doc.add_paragraph()
    p_sub.paragraph_format.space_before = Pt(0)
    p_sub.paragraph_format.space_after = Pt(18)
    p_sub.alignment = WD_ALIGN_PARAGRAPH.CENTER
    r_sub = p_sub.add_run("Asignación de Bloques (Contigua, Enlazada, FAT e Indexada) y Estructura de Directorios")
    r_sub.font.name = 'Calibri'
    r_sub.font.size = Pt(11)
    r_sub.font.italic = True
    r_sub.font.color.rgb = COLOR_MUTED

    # Horizontal divider
    p_hr = doc.add_paragraph()
    p_hr.paragraph_format.space_after = Pt(14)
    p_hr_border = parse_xml(f'<w:pBdr {nsdecls("w")}><w:bottom w:val="single" w:sz="12" w:space="1" w:color="1B365D"/></w:pBdr>')
    p_hr._p.get_or_add_pPr().append(p_hr_border)

def add_heading_1(text):
    p = doc.add_paragraph()
    p.paragraph_format.space_before = Pt(18)
    p.paragraph_format.space_after = Pt(6)
    p.paragraph_format.keep_with_next = True
    run = p.add_run(text)
    run.font.name = 'Calibri'
    run.font.size = Pt(14)
    run.font.bold = True
    run.font.color.rgb = COLOR_PRIMARY
    return p

def add_heading_2(text):
    p = doc.add_paragraph()
    p.paragraph_format.space_before = Pt(12)
    p.paragraph_format.space_after = Pt(4)
    p.paragraph_format.keep_with_next = True
    run = p.add_run(text)
    run.font.name = 'Calibri'
    run.font.size = Pt(12)
    run.font.bold = True
    run.font.color.rgb = COLOR_SECONDARY
    return p

def add_paragraph_styled(text, bold_prefix=None, italic=False, space_after=6):
    p = doc.add_paragraph()
    p.paragraph_format.space_after = Pt(space_after)
    p.paragraph_format.line_spacing = 1.15
    if bold_prefix:
        r_pre = p.add_run(bold_prefix)
        r_pre.font.name = 'Calibri'
        r_pre.font.size = Pt(11)
        r_pre.font.bold = True
        r_pre.font.color.rgb = COLOR_TEXT
    run = p.add_run(text)
    run.font.name = 'Calibri'
    run.font.size = Pt(11)
    run.font.italic = italic
    run.font.color.rgb = COLOR_TEXT
    return p

def add_callout(text, bold_title=None, bg_color="F1F5F9", border_color="3B82F6"):
    tbl = doc.add_table(rows=1, cols=1)
    tbl.alignment = WD_TABLE_ALIGNMENT.CENTER
    cell = tbl.cell(0, 0)
    set_cell_background(cell, bg_color)
    set_cell_margins(cell, top=120, bottom=120, left=180, right=180)
    
    tcPr = cell._tc.get_or_add_tcPr()
    borders_elm = parse_xml(f'''
        <w:tcBorders {nsdecls("w")}>
            <w:top w:val="none"/>
            <w:left w:val="single" w:sz="24" w:space="0" w:color="{border_color}"/>
            <w:bottom w:val="none"/>
            <w:right w:val="none"/>
        </w:tcBorders>
    ''')
    tcPr.append(borders_elm)
    
    p = cell.paragraphs[0]
    p.paragraph_format.space_before = Pt(2)
    p.paragraph_format.space_after = Pt(2)
    p.paragraph_format.line_spacing = 1.15
    if bold_title:
        rb = p.add_run(bold_title + " ")
        rb.font.name = 'Calibri'
        rb.font.size = Pt(10.5)
        rb.font.bold = True
        rb.font.color.rgb = COLOR_PRIMARY
    r = p.add_run(text)
    r.font.name = 'Calibri'
    r.font.size = Pt(10.5)
    r.font.color.rgb = COLOR_TEXT
    doc.add_paragraph().paragraph_format.space_after = Pt(4)

def add_image_with_caption(img_path, caption, width=Inches(6.2)):
    if os.path.exists(img_path):
        p_img = doc.add_paragraph()
        p_img.alignment = WD_ALIGN_PARAGRAPH.CENTER
        p_img.paragraph_format.space_before = Pt(8)
        p_img.paragraph_format.space_after = Pt(4)
        run_img = p_img.add_run()
        run_img.add_picture(img_path, width=width)
        
        p_cap = doc.add_paragraph()
        p_cap.alignment = WD_ALIGN_PARAGRAPH.CENTER
        p_cap.paragraph_format.space_after = Pt(12)
        r_cap = p_cap.add_run(caption)
        r_cap.font.name = 'Calibri'
        r_cap.font.size = Pt(9.5)
        r_cap.font.italic = True
        r_cap.font.color.rgb = COLOR_MUTED

# ==============================================================================
# BUILD CONTENT
# ==============================================================================
add_header_block()

# ------------------------------------------------------------------------------
# EJERCICIO 1
# ------------------------------------------------------------------------------
add_heading_1("Ejercicio 1: Asignación Mediante Encadenamiento y Tabla FAT")

add_paragraph_styled(
    "Considerando un almacenamiento secundario formado por 24 bloques en donde residen los archivos A, B, C, D y E de acuerdo al siguiente esquema:",
    bold_prefix="Consigna: "
)

# Table 1: Initial schema
t1 = doc.add_table(rows=6, cols=4)
t1.alignment = WD_TABLE_ALIGNMENT.CENTER
headers_t1 = ["Archivo", "Localización Inicial", "Bloques Adicionales", "Longitud Total"]
data_t1 = [
    ["Archivo A (Rojo)", "B00", "B12 → B18 → B07", "4 bloques"],
    ["Archivo B (Azul)", "B21", "B02 → B04 → B05", "4 bloques"],
    ["Archivo C (Verde)", "B23", "B17 → B01 → B08 → B16 → B11", "6 bloques"],
    ["Archivo D (Amarillo)", "B03", "B09 → B13 → B19 → B14", "5 bloques"],
    ["Archivo E (Naranja)", "B06", "(Sin bloques adicionales)", "1 bloque"]
]

for col_idx, text in enumerate(headers_t1):
    c = t1.cell(0, col_idx)
    set_cell_background(c, "1B365D")
    set_cell_margins(c, 100, 100, 120, 120)
    p = c.paragraphs[0]
    p.alignment = WD_ALIGN_PARAGRAPH.CENTER
    r = p.add_run(text)
    r.font.name = 'Calibri'
    r.font.size = Pt(10)
    r.font.bold = True
    r.font.color.rgb = RGBColor(255, 255, 255)

for r_idx, row_data in enumerate(data_t1):
    for c_idx, val in enumerate(row_data):
        c = t1.cell(r_idx + 1, c_idx)
        bg = "FFFFFF" if r_idx % 2 == 0 else "F8FAFC"
        set_cell_background(c, bg)
        set_cell_margins(c, 80, 80, 100, 100)
        set_cell_borders(c, "E2E8F0", "E2E8F0")
        p = c.paragraphs[0]
        p.alignment = WD_ALIGN_PARAGRAPH.CENTER if c_idx != 2 else WD_ALIGN_PARAGRAPH.LEFT
        r = p.add_run(val)
        r.font.name = 'Calibri'
        r.font.size = Pt(9.5)
        if c_idx == 0:
            r.font.bold = True

doc.add_paragraph().paragraph_format.space_after = Pt(6)

add_paragraph_styled("El resto de los bloques están libres.", bold_prefix="Nota: ", italic=True)
add_paragraph_styled(
    "Cómo se realizaría la implantación del sistema de archivos, utilizando la asignación de bloques mediante:\n"
    "a) Encadenamiento de bloques.\n"
    "b) Transformaciones de archivos orientados hacia bloques (TABLA FAT)."
)

# Subpoint a
add_heading_2("a) Encadenamiento de bloques")
add_paragraph_styled(
    "En este método de asignación no contigua, cada archivo se almacena como una lista enlazada de bloques de disco. "
    "Cada bloque físico asignado al archivo contiene tanto los datos útiles como un puntero al siguiente bloque de la secuencia. "
    "El directorio del sistema de archivos únicamente necesita almacenar la dirección del bloque inicial (y en algunos casos el bloque final). "
    "En la grilla a continuación se representa el almacenamiento secundario de 24 bloques (del B00 al B23, distribuidos en 4 filas por 6 columnas), "
    "donde cada celda identifica el bloque físico, el archivo al cual pertenece y su orden lógico relativo:"
)

# Insert Grid graphic
add_image_with_caption(
    f"{img_dir}/grafico_ej1_encadenamiento.png",
    "Figura 1: Mapa del almacenamiento secundario de 24 bloques bajo el esquema de encadenamiento de bloques."
)

# Grid table representation
add_paragraph_styled("Representación matricial del almacenamiento (Grilla de 4 × 6 bloques):", bold_prefix="Matriz de Bloques: ")
t_grid = doc.add_table(rows=5, cols=7)
t_grid.alignment = WD_TABLE_ALIGNMENT.CENTER
t_grid_headers = ["Fila / Rango", "Col 1", "Col 2", "Col 3", "Col 4", "Col 5", "Col 6"]
for c_idx, h in enumerate(t_grid_headers):
    c = t_grid.cell(0, c_idx)
    set_cell_background(c, "2B547E")
    set_cell_margins(c, 80, 80, 80, 80)
    p = c.paragraphs[0]
    p.alignment = WD_ALIGN_PARAGRAPH.CENTER
    r = p.add_run(h)
    r.font.name = 'Calibri'
    r.font.size = Pt(9.5)
    r.font.bold = True
    r.font.color.rgb = RGBColor(255, 255, 255)

grid_rows = [
    ["Fila 1 (B00 - B05)", "B00: A(1)", "B01: C(3)", "B02: B(2)", "B03: D(1)", "B04: B(3)", "B05: B(4)"],
    ["Fila 2 (B06 - B11)", "B06: E(1)", "B07: A(4)", "B08: C(4)", "B09: D(2)", "B10: Libre", "B11: C(6)"],
    ["Fila 3 (B12 - B17)", "B12: A(2)", "B13: D(3)", "B14: D(5)", "B15: Libre", "B16: C(5)", "B17: C(2)"],
    ["Fila 4 (B18 - B23)", "B18: A(3)", "B19: D(4)", "B20: Libre", "B21: B(1)", "B22: Libre", "B23: C(1)"]
]

for r_idx, row in enumerate(grid_rows):
    for c_idx, val in enumerate(row):
        c = t_grid.cell(r_idx + 1, c_idx)
        bg = "FFFFFF" if r_idx % 2 == 0 else "F8FAFC"
        if "Libre" in val:
            bg = "F1F5F9"
        set_cell_background(c, bg)
        set_cell_margins(c, 70, 70, 70, 70)
        set_cell_borders(c, "CBD5E1", "CBD5E1", "CBD5E1", "CBD5E1")
        p = c.paragraphs[0]
        p.alignment = WD_ALIGN_PARAGRAPH.CENTER
        r = p.add_run(val)
        r.font.name = 'Calibri'
        r.font.size = Pt(9)
        if c_idx == 0:
            r.font.bold = True
        elif "Libre" in val:
            r.font.italic = True
            r.font.color.rgb = COLOR_MUTED

doc.add_paragraph().paragraph_format.space_after = Pt(8)

# Subpoint b: FAT
add_heading_2("b) Transformaciones de archivos orientados hacia bloques (TABLA FAT)")
add_paragraph_styled(
    "La asignación mediante Tabla de Asignación de Archivos (FAT, File Allocation Table) constituye una optimización directa "
    "del encadenamiento de bloques. En lugar de embeber el puntero de enlace dentro de cada bloque físico (lo que reduciría el espacio útil "
    "para datos y exigiría leer cada bloque de disco para recorrer la cadena), se extraen todos los punteros y se centralizan en una tabla "
    "indexada por el número de bloque. De esta manera, cada entrada de la tabla representa un bloque físico y contiene la dirección del "
    "siguiente bloque de la cadena, una marca especial de fin de archivo (EOF / -1) o una indicación de que el bloque se encuentra Libre."
)

# Table FAT
t_fat = doc.add_table(rows=13, cols=6)
t_fat.alignment = WD_TABLE_ALIGNMENT.CENTER

fat_headers = ["Entrada", "Sig. Bloque", "Archivo", "Entrada", "Sig. Bloque", "Archivo"]
for c_idx, h in enumerate(fat_headers):
    c = t_fat.cell(0, c_idx)
    set_cell_background(c, "1B365D")
    set_cell_margins(c, 80, 80, 80, 80)
    p = c.paragraphs[0]
    p.alignment = WD_ALIGN_PARAGRAPH.CENTER
    r = p.add_run(h)
    r.font.name = 'Calibri'
    r.font.size = Pt(9)
    r.font.bold = True
    r.font.color.rgb = RGBColor(255, 255, 255)

fat_data_pairs = [
    ("00", "12", "Archivo A", "12", "18", "Archivo A"),
    ("01", "08", "Archivo C", "13", "19", "Archivo D"),
    ("02", "04", "Archivo B", "14", "EOF / -1", "Archivo D (Fin)"),
    ("03", "09", "Archivo D", "15", "Libre", "Libre"),
    ("04", "05", "Archivo B", "16", "11", "Archivo C"),
    ("05", "EOF / -1", "Archivo B (Fin)", "17", "01", "Archivo C"),
    ("06", "EOF / -1", "Archivo E (Fin)", "18", "07", "Archivo A"),
    ("07", "EOF / -1", "Archivo A (Fin)", "19", "14", "Archivo D"),
    ("08", "16", "Archivo C", "20", "Libre", "Libre"),
    ("09", "13", "Archivo D", "21", "02", "Archivo B"),
    ("10", "Libre", "Libre", "22", "Libre", "Libre"),
    ("11", "EOF / -1", "Archivo C (Fin)", "23", "17", "Archivo C")
]

for r_idx, row_vals in enumerate(fat_data_pairs):
    for c_idx, val in enumerate(row_vals):
        c = t_fat.cell(r_idx + 1, c_idx)
        bg = "FFFFFF" if r_idx % 2 == 0 else "F8FAFC"
        if "Libre" in val:
            bg = "F1F5F9"
        elif "EOF" in val:
            bg = "FEF2F2"
        set_cell_background(c, bg)
        set_cell_margins(c, 60, 60, 60, 60)
        set_cell_borders(c, "E2E8F0", "E2E8F0", "E2E8F0", "E2E8F0")
        p = c.paragraphs[0]
        p.alignment = WD_ALIGN_PARAGRAPH.CENTER
        r = p.add_run(val)
        r.font.name = 'Calibri'
        r.font.size = Pt(8.5)
        if "EOF" in val:
            r.font.bold = True
            r.font.color.rgb = RGBColor(185, 28, 28)
        elif "Libre" in val:
            r.font.italic = True
            r.font.color.rgb = COLOR_MUTED

doc.add_paragraph().paragraph_format.space_after = Pt(8)

# Insert FAT Flow graphic
add_image_with_caption(
    f"{img_dir}/grafico_ej1_fat_flow.png",
    "Figura 2: Diagrama de las cadenas de bloques enlazadas en la Tabla FAT para los archivos A, B, C, D y E."
)

add_callout(
    "Resumen del estado del almacenamiento:\n"
    "• Total de bloques del disco: 24 bloques (B00 a B23).\n"
    "• Bloques ocupados por archivos: 20 bloques (A: 4, B: 4, C: 6, D: 5, E: 1).\n"
    "• Bloques libres disponibles: 4 bloques (B10, B15, B20 y B22).",
    bold_title="Estado de Ocupación:"
)

# ------------------------------------------------------------------------------
# EJERCICIO 2 / 4 (SEGUNDO ESQUEMA)
# ------------------------------------------------------------------------------
add_heading_1("Ejercicio 4: Encadenamiento, FAT y Modificaciones Dinámicas (Archivos Z, V, S, H, U)")

add_paragraph_styled(
    "En esta configuración del almacenamiento secundario de 24 bloques, se estructuran los archivos Z, V, S, H y U "
    "de acuerdo con las siguientes cadenas de asignación:",
    bold_prefix="Definición del Sistema: "
)

t2_files = doc.add_table(rows=6, cols=4)
t2_files.alignment = WD_TABLE_ALIGNMENT.CENTER
for c_idx, h in enumerate(["Archivo", "Localización Inicial", "Cadena de Bloques Enlazados", "Longitud"]):
    c = t2_files.cell(0, c_idx)
    set_cell_background(c, "1B365D")
    set_cell_margins(c, 80, 80, 100, 100)
    p = c.paragraphs[0]
    p.alignment = WD_ALIGN_PARAGRAPH.CENTER
    r = p.add_run(h)
    r.font.name = 'Calibri'
    r.font.size = Pt(9.5)
    r.font.bold = True
    r.font.color.rgb = RGBColor(255, 255, 255)

data_t2 = [
    ["Archivo Z", "B09", "B09 → B13 → B05 → B02 → B00", "5 bloques"],
    ["Archivo V", "B06", "B06 → B08 → B01 → B17 → B11 → B20", "6 bloques"],
    ["Archivo S", "B03", "B03 → B16", "2 bloques"],
    ["Archivo H", "B07", "B07 → B04 → B18 → B14 → B22", "5 bloques"],
    ["Archivo U", "B12", "B12 → B19 → B23", "3 bloques"]
]

for r_idx, row in enumerate(data_t2):
    for c_idx, val in enumerate(row):
        c = t2_files.cell(r_idx + 1, c_idx)
        bg = "FFFFFF" if r_idx % 2 == 0 else "F8FAFC"
        set_cell_background(c, bg)
        set_cell_margins(c, 70, 70, 90, 90)
        set_cell_borders(c, "E2E8F0", "E2E8F0")
        p = c.paragraphs[0]
        p.alignment = WD_ALIGN_PARAGRAPH.CENTER if c_idx != 2 else WD_ALIGN_PARAGRAPH.LEFT
        r = p.add_run(val)
        r.font.name = 'Calibri'
        r.font.size = Pt(9)
        if c_idx == 0:
            r.font.bold = True

doc.add_paragraph().paragraph_format.space_after = Pt(6)

add_heading_2("a) Encadenamiento de bloques")
add_paragraph_styled(
    "La memoria secundaria se organiza en una matriz de 3 filas × 8 columnas (24 bloques). "
    "La asignación y orden lógico de cada bloque físico se ilustra a continuación:"
)

# Insert Grid graphic 2
add_image_with_caption(
    f"{img_dir}/grafico_ej2_encadenamiento.png",
    "Figura 3: Representación de la memoria secundaria de 24 bloques bajo el esquema Z, V, S, H, U (Grilla 3 × 8)."
)

add_heading_2("b) Transformaciones de archivos orientados hacia bloques (TABLA FAT)")
add_paragraph_styled(
    "A continuación se presenta la transcripción completa y ordenada de la tabla de asignación orientada a bloques (FAT):"
)

# FAT 2 Table
t_fat2 = doc.add_table(rows=25, cols=3)
t_fat2.alignment = WD_TABLE_ALIGNMENT.CENTER
for c_idx, h in enumerate(["Bloque (Entrada)", "Contenido / Archivo", "Siguiente Bloque"]):
    c = t_fat2.cell(0, c_idx)
    set_cell_background(c, "2B547E")
    set_cell_margins(c, 70, 70, 100, 100)
    p = c.paragraphs[0]
    p.alignment = WD_ALIGN_PARAGRAPH.CENTER
    r = p.add_run(h)
    r.font.name = 'Calibri'
    r.font.size = Pt(9)
    r.font.bold = True
    r.font.color.rgb = RGBColor(255, 255, 255)

fat2_rows = [
    ("B00", "Z (Bloque 5)", "EOF / -1"),
    ("B01", "V (Bloque 3)", "B17"),
    ("B02", "Z (Bloque 4)", "B00"),
    ("B03", "S (Bloque 1)", "B16"),
    ("B04", "H (Bloque 2)", "B18"),
    ("B05", "Z (Bloque 3)", "B02"),
    ("B06", "V (Bloque 1)", "B08"),
    ("B07", "H (Bloque 1)", "B04"),
    ("B08", "V (Bloque 2)", "B01"),
    ("B09", "Z (Bloque 1)", "B13"),
    ("B10", "Libre", "—"),
    ("B11", "V (Bloque 5)", "B20"),
    ("B12", "U (Bloque 1)", "B19"),
    ("B13", "Z (Bloque 2)", "B05"),
    ("B14", "H (Bloque 4)", "B22"),
    ("B15", "Libre", "—"),
    ("B16", "S (Bloque 2)", "EOF / -1"),
    ("B17", "V (Bloque 4)", "B11"),
    ("B18", "H (Bloque 3)", "B14"),
    ("B19", "U (Bloque 2)", "B23"),
    ("B20", "V (Bloque 6)", "EOF / -1"),
    ("B21", "Libre", "—"),
    ("B22", "H (Bloque 5)", "EOF / -1"),
    ("B23", "U (Bloque 3)", "EOF / -1")
]

for r_idx, (b_in, cont, nxt) in enumerate(fat2_rows):
    row_cells = t_fat2.rows[r_idx + 1].cells
    bg = "FFFFFF" if r_idx % 2 == 0 else "F8FAFC"
    if "Libre" in cont:
        bg = "F1F5F9"
    elif "EOF" in nxt:
        bg = "FEF2F2"
    for c_idx, val in enumerate([b_in, cont, nxt]):
        c = row_cells[c_idx]
        set_cell_background(c, bg)
        set_cell_margins(c, 50, 50, 80, 80)
        set_cell_borders(c, "E2E8F0", "E2E8F0")
        p = c.paragraphs[0]
        p.alignment = WD_ALIGN_PARAGRAPH.CENTER
        r = p.add_run(val)
        r.font.name = 'Calibri'
        r.font.size = Pt(8.5)
        if c_idx == 0:
            r.font.bold = True
        if "EOF" in val:
            r.font.bold = True
            r.font.color.rgb = RGBColor(185, 28, 28)
        elif "Libre" in val:
            r.font.italic = True
            r.font.color.rgb = COLOR_MUTED

doc.add_paragraph().paragraph_format.space_after = Pt(8)

# Subpoints i, ii, iii
add_heading_2("Respuestas a Modificaciones del Sistema de Archivos")

add_callout(
    "Si se elimina el archivo U, aparte de los bloques B10, B15 y B21 también quedarían libres los bloques B12, B19 y B23. "
    "Tras eliminarlo, esos 3 bloques adicionales quedan disponibles, sumando un total de 6 bloques libres en el disco "
    "(B10, B12, B15, B19, B21, B23). Las estructuras de los demás archivos no sufren ninguna alteración.",
    bold_title="i) Eliminación del Archivo U:"
)

add_callout(
    "Si partimos del estado inicial solo tenemos 3 bloques libres (B10, B15, B21) pero necesitamos 5 espacios físicos "
    "para alojar el nuevo archivo. Por lo tanto, NO HAY ESPACIO SUFICIENTE en el almacenamiento para realizar el encadenamiento de bloques "
    "(faltarían 2 bloques para completar la solicitud).",
    bold_title="ii) Agregado de un Archivo de Longitud 5 Bloques:",
    bg_color="FFFBEB", border_color="F59E0B"
)

add_callout(
    "Si el archivo S aumentara 4 bloques físicos, su cadena de asignación pasaría a requerir: "
    "B03 → B16 → nuevo → nuevo → nuevo → nuevo (longitud total de 6 bloques). "
    "Sin embargo, dado que inicialmente solo disponemos de 3 bloques libres (B10, B15, B21), "
    "el archivo S TAMPOCO PUEDE CRECER 4 bloques por insuficiencia de espacio en disco.",
    bold_title="iii) Crecimiento del Archivo S en 4 Bloques:",
    bg_color="FFFBEB", border_color="F59E0B"
)

# ------------------------------------------------------------------------------
# EJERCICIOS 5 Y 6
# ------------------------------------------------------------------------------
add_heading_1("Ejercicios 5 y 6: Estructura de Directorios y Resolución de Rutas")

add_paragraph_styled(
    "En los sistemas de archivos jerárquicos (como UNIX/Linux), las rutas permiten ubicar de forma unívoca cualquier archivo o directorio. "
    "Se distinguen dos tipos fundamentales de rutas:\n"
    "• Ruta Absoluta: Especifica la ubicación completa partiendo desde el directorio raíz ('/'). Es independiente del directorio de trabajo actual.\n"
    "• Ruta Relativa: Especifica la ubicación tomando como punto de partida el directorio de trabajo actual (directorio activo). "
    "Utiliza la convención '.' para referirse al directorio actual y '..' para ascender al directorio padre."
)

# Unified Directory Tree Graphic
add_image_with_caption(
    f"{img_dir}/grafico_ej5_6_rutas.png",
    "Figura 4: Árbol jerárquico del sistema de archivos correspondiente a los Ejercicios 5 y 6."
)

add_heading_2("Ejercicio 5: Resolución de Rutas")
add_paragraph_styled("Rutas de acceso absoluto para canción.mp3 e imagen.png:", bold_prefix="a) Rutas Absolutas: ")
doc.add_paragraph("• cancion.mp3:  /home/pedro/musica/cancion.mp3", style='List Bullet')
doc.add_paragraph("• imagen.png:   /home/ana/descargas/imagen.png", style='List Bullet')

add_paragraph_styled("Rutas solicitadas para notas.txt y red.conf:", bold_prefix="b) Rutas Específicas: ")
doc.add_paragraph("• Ruta para 'notas.txt':  /proyectos/notas.txt  (Ruta absoluta)", style='List Bullet')
doc.add_paragraph("• Ruta para 'red.conf':   ../../etc/config/red.conf  (Ruta relativa ascendiendo dos niveles desde el subdirectorio de trabajo hacia la raíz y navegando luego a etc/config/)", style='List Bullet')

doc.add_paragraph().paragraph_format.space_after = Pt(4)

add_heading_2("Ejercicio 6: Resolución de Rutas")
add_paragraph_styled("Rutas de acceso absoluto para los archivos deploy.sh y respaldo_2025.zip:", bold_prefix="a) Rutas Absolutas: ")
doc.add_paragraph("• deploy.sh:          /srv/diego/scripts/deploy.sh", style='List Bullet')
doc.add_paragraph("• respaldo_2025.zip:  /srv/laura/backups/respaldo_2025.zip", style='List Bullet')

add_paragraph_styled("Rutas solicitadas para estilo.css y compresor:", bold_prefix="b) Rutas Específicas: ")
doc.add_paragraph("• Ruta para 'estilo.css':  /web/estilo.css  (Ruta absoluta)", style='List Bullet')
doc.add_paragraph("• Ruta para 'compresor':   ../../bin/utilidades/compresor  (Ruta relativa ascendiendo dos niveles hacia la raíz y descendiendo por bin/utilidades/)", style='List Bullet')

doc.add_paragraph().paragraph_format.space_after = Pt(8)

# ------------------------------------------------------------------------------
# EJERCICIO 7
# ------------------------------------------------------------------------------
add_heading_1("Ejercicio 7: Asignación Contigua y Fragmentación Externa")

add_paragraph_styled(
    "La asignación contigua exige que cada archivo o proceso ocupe un conjunto de bloques consecutivos contiguos en el disco. "
    "Esto ofrece un rendimiento excelente para accesos secuenciales y directos, pero presenta graves problemas de fragmentación.",
    bold_prefix="Fundamento Teórico: "
)

add_callout(
    "Para la asignación contigua necesitamos asignarle 4 bloques seguidos a P1. "
    "Al inspeccionar el mapa de almacenamiento, el único hueco libre contiguo existente está formado por los bloques "
    "B16 a B19 (B16, B17, B18, B19), los cuales son justamente 4 bloques libres continuos. "
    "Por consiguiente, se asigna con éxito el rango [B16, B19] a P1.",
    bold_title="i) Asignación Contigua para P1 (4 bloques requeridos):"
)

add_callout(
    "P2 necesita 5 bloques libres en estado contiguo. Sin embargo, no existe ningún hueco libre contiguo de 5 bloques en el disco, "
    "a pesar de que el almacenamiento cuenta con 6 bloques libres en total.\n\n"
    "⚠️ Conclusión: Para P2 NO SE PUEDE realizar la asignación debido al fenómeno de FRAGMENTACIÓN EXTERNA. "
    "La fragmentación externa ocurre cuando existe suficiente espacio de almacenamiento total libre para satisfacer la petición, "
    "pero dicho espacio no se encuentra de forma contigua, sino fragmentado en bloques dispersos.",
    bold_title="ii) Asignación para P2 (5 bloques requeridos) y Fragmentación Externa:",
    bg_color="FEF2F2", border_color="EF4444"
)

# Insert Contiguous Graphic
add_image_with_caption(
    f"{img_dir}/grafico_ej7_asignacion_contigua.png",
    "Figura 5: Mapa de asignación contigua en disco que ilustra el hueco asignado a P1 y la fragmentación externa para P2."
)

# ------------------------------------------------------------------------------
# EJERCICIO 8
# ------------------------------------------------------------------------------
add_heading_1("Ejercicio 8: Asignación Indexada con Límite de Entradas por Bloque Índice")

add_paragraph_styled(
    "En este problema se implementa el método de Asignación Indexada para la gestión de archivos en un almacenamiento de 16 bloques (del B00 al B15):\n"
    "• Bloques ocupados inicialmente por datos (10 bloques): 00, 03, 05, 07, 09, 10, 11, 13, 14, 15.\n"
    "• Bloques libres disponibles para índices (6 bloques): 01, 02, 04, 06, 08, 12.\n"
    "• Restricción del sistema: Cada bloque de índice admite un máximo de 3 entradas. "
    "Si un archivo requiere más de 3 bloques de datos, se requerirán múltiples bloques de índice encadenados entre sí para cubrir la totalidad de sus entradas.",
    bold_prefix="Condiciones Iniciales y Reglas: "
)

# Details J1, J2, J3
t_idx = doc.add_table(rows=4, cols=5)
t_idx.alignment = WD_TABLE_ALIGNMENT.CENTER
for c_idx, h in enumerate(["Archivo", "Bloques de Datos", "Cantidad de Datos", "Bloques Índice Necesarios", "Bloque(s) Asignado(s)"]):
    c = t_idx.cell(0, c_idx)
    set_cell_background(c, "1B365D")
    set_cell_margins(c, 80, 80, 80, 80)
    p = c.paragraphs[0]
    p.alignment = WD_ALIGN_PARAGRAPH.CENTER
    r = p.add_run(h)
    r.font.name = 'Calibri'
    r.font.size = Pt(9)
    r.font.bold = True
    r.font.color.rgb = RGBColor(255, 255, 255)

data_idx = [
    ["Archivo J1", "B15, B14, B09", "3 bloques", "1 bloque índice", "Bloque libre B01"],
    ["Archivo J2", "B05, B11, B00, B07, B13", "5 bloques", "2 bloques índice (encadenados)", "Bloques libres B02 y B04"],
    ["Archivo J3", "B03, B10", "2 bloques", "1 bloque índice", "Bloque libre B06"]
]

for r_idx, row in enumerate(data_idx):
    for c_idx, val in enumerate(row):
        c = t_idx.cell(r_idx + 1, c_idx)
        bg = "FFFFFF" if r_idx % 2 == 0 else "F8FAFC"
        set_cell_background(c, bg)
        set_cell_margins(c, 70, 70, 80, 80)
        set_cell_borders(c, "E2E8F0", "E2E8F0")
        p = c.paragraphs[0]
        p.alignment = WD_ALIGN_PARAGRAPH.CENTER
        r = p.add_run(val)
        r.font.name = 'Calibri'
        r.font.size = Pt(9)
        if c_idx == 0:
            r.font.bold = True

doc.add_paragraph().paragraph_format.space_after = Pt(8)

add_paragraph_styled("Detalle del encadenamiento de bloques índice para J2:", bold_prefix="Encadenamiento Multinivel: ")
add_paragraph_styled(
    "Como el archivo J2 cuenta con 5 bloques de datos y cada bloque índice solo tiene capacidad para 3 entradas, "
    "se utiliza un esquema de encadenamiento entre bloques índices:\n"
    "1. Bloque Índice B02 (Índice 1): Contiene los punteros a los 3 primeros bloques de datos [B05, B11, B00] y el puntero de enlace hacia el siguiente bloque índice (B04).\n"
    "2. Bloque Índice B04 (Índice 2): Contiene los punteros a los 2 bloques de datos restantes [B07, B13] y la marca de fin de archivo (EOF)."
)

add_callout(
    "De los 6 bloques libres disponibles originalmente (B01, B02, B04, B06, B08, B12), se utilizaron 4 como bloques de índice "
    "(B01 para J1; B02 y B04 para J2; B06 para J3).\n"
    "Por consiguiente, quedan libres y no asignados los bloques: B08 y B12 (Total: 2 bloques libres remanentes).",
    bold_title="Balance de Bloques Libres Remanentes:"
)

# Insert Indexed Graphic
add_image_with_caption(
    f"{img_dir}/grafico_ej8_asignacion_indexada.png",
    "Figura 6: Esquema de asignación indexada con bloques índice encadenados para los archivos J1, J2 y J3."
)

# Original drawing
if os.path.exists(f"{img_dir}/gengar_original.png"):
    add_paragraph_styled("Ilustración manuscrita original del práctico (Gengar):", bold_prefix="Anexo Gráfico Manuscrito: ")
    add_image_with_caption(
        f"{img_dir}/gengar_original.png",
        "Figura 7: Detalle del dibujo manuscrito original presente en la hoja del práctico.",
        width=Inches(2.8)
    )

# Save document
doc.save(doc_path)
print(f"DOCUMENT SAVED SUCCESSFULLY TO: {doc_path}")

# Also save a copy as TP3_Resuelto.docx in the same folder
doc.save('/home/gabriel/Documentos/UNNE/UNNE1/Sistemas Operativos/Cursada/TPS/TP3_Resuelto.docx')
print("Secondary copy saved as TP3_Resuelto.docx")
