package com.example.myapplication.data.models.response


import com.squareup.moshi.Json

data class MedicineResponse(
    @Json(name = "problems")
    val problems: List<Problem> = emptyList()
) {
    data class Problem(
        @Json(name = "Asthma")
        val asthma: List<Asthma?>?,
        @Json(name = "Diabetes")
        val diabetes: List<Diabete>  = emptyList()
    ) {
        class Asthma

        data class Diabete(
            @Json(name = "labs")
            val labs: List<Lab?> = emptyList(),
            @Json(name = "medications")
            val medications: List<Medication>  = emptyList()
        ) {
            data class Lab(
                @Json(name = "missing_field")
                val missingField: String?
            )

            data class Medication(
                @Json(name = "medicationsClasses")
                val medicationsClasses: List<MedicationsClasse> = emptyList()
            ) {
                data class MedicationsClasse(
                    @Json(name = "className")
                    val className: List<ClassName> = emptyList(),
                    @Json(name = "className2")
                    val className2: List<ClassName2> = emptyList()
                ) {
                    data class ClassName(
                        @Json(name = "associatedDrug")
                        val associatedDrug: List<AssociatedDrug> = emptyList(),
                        @Json(name = "associatedDrug#2")
                        val associatedDrug2: List<AssociatedDrug2> = emptyList()
                    ) {
                        data class AssociatedDrug(
                            @Json(name = "dose")
                            val dose: String?,
                            @Json(name = "name")
                            val name: String?,
                            @Json(name = "strength")
                            val strength: String?
                        )

                        data class AssociatedDrug2(
                            @Json(name = "dose")
                            val dose: String?,
                            @Json(name = "name")
                            val name: String?,
                            @Json(name = "strength")
                            val strength: String?
                        )
                    }

                    data class ClassName2(
                        @Json(name = "associatedDrug")
                        val associatedDrug: List<AssociatedDrug?>?,
                        @Json(name = "associatedDrug#2")
                        val associatedDrug2: List<AssociatedDrug2?>?
                    ) {
                        data class AssociatedDrug(
                            @Json(name = "dose")
                            val dose: String?,
                            @Json(name = "name")
                            val name: String?,
                            @Json(name = "strength")
                            val strength: String?
                        )

                        data class AssociatedDrug2(
                            @Json(name = "dose")
                            val dose: String?,
                            @Json(name = "name")
                            val name: String?,
                            @Json(name = "strength")
                            val strength: String?
                        )
                    }
                }
            }
        }
    }
}